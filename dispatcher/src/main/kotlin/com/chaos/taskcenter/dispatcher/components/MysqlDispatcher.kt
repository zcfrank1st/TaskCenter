package com.chaos.taskcenter.dispatcher.components

import com.chaos.taskcenter.jooq.generated.Tables.*
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import com.typesafe.config.ConfigFactory
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch
import org.joda.time.DateTime
import org.jooq.SQLDialect
import org.jooq.impl.DSL
import org.jooq.types.UByte
import org.jooq.types.UInteger
import java.util.*
import javax.sql.DataSource

/**
 * Created by zcfrank1st on 10/06/2017.
 */
val components = Kodein {
    val configProperties = ConfigFactory.load()

    bind<Quartz>() with singleton { Quartz() }
    bind<DataSource>() with singleton {
        val config = HikariConfig()
        config.poolName = "dispatcher-pool-${UUID.randomUUID().toString().replace("-", "")}"
        config.jdbcUrl  = configProperties.getString("taskcenter.dispatcher.db.url")
        config.username = configProperties.getString("taskcenter.dispatcher.db.username")
        config.password = configProperties.getString("taskcenter.dispatcher.db.password")
        HikariDataSource(config)
    }
}

object MysqlDispatcher: DispatcherOperator {
    private val dataSource: DataSource = components.instance()
    private val quartz: Quartz = components.instance()

    override fun doDispatcher() {
        val create = DSL.using(dataSource, SQLDialect.MYSQL)
        create.transaction { configuration ->
            val ctx = DSL.using(configuration)
            // 锁
            ctx.select()
                    .from(TASK_LOCK)
                    .where(TASK_LOCK.LOCK_NAME.eq("DISPATCHER_LOCK"))
                    .forUpdate()
                    .fetch()
            // 获取任务模板
            val templateRecords = ctx.select()
                    .from(SCHEDULED_TASK_SKELETON)
                    .where(SCHEDULED_TASK_SKELETON.IS_INIT.eq(UByte.valueOf(0)))
                    .and(SCHEDULED_TASK_SKELETON.IS_VALID.eq(UByte.valueOf(0)))
                    .and("last_execute_time <= now()")
                    .fetch()
            // 过滤获得需要初始化记录
            for (record in templateRecords) {
                val taskId = record.getValue(SCHEDULED_TASK_SKELETON.TASK_ID)
                val taskName = record.getValue(SCHEDULED_TASK_SKELETON.TASK_NAME)
                val taskContent = record.getValue(SCHEDULED_TASK_SKELETON.TASK_CONTENT)
                val param = record.getValue(SCHEDULED_TASK_SKELETON.PARAM)
                val taskType = record.getValue(SCHEDULED_TASK_SKELETON.TASK_TYPE)
                val retryTimeThreshold = record.getValue(SCHEDULED_TASK_SKELETON.RETRY_TIME_THRESHOLD)

                val referTaskIds = record.getValue(SCHEDULED_TASK_SKELETON.REFER_TASK_IDS)

                val nextTime = quartz.nextExecuteTime(record.getValue(SCHEDULED_TASK_SKELETON.QUARTZ_EXPRESSION))
                // 更新初始化id，获取id
                ctx.update(SCHEDULED_TASK_ASSIGNER)
                        .set(SCHEDULED_TASK_ASSIGNER.TAG, SCHEDULED_TASK_ASSIGNER.TAG + 1)
                        .where(SCHEDULED_TASK_ASSIGNER.TASK_ID.eq(taskId))
                        .execute()

                val tag = ctx.select().from(SCHEDULED_TASK_ASSIGNER).where(SCHEDULED_TASK_ASSIGNER.TASK_ID.eq(taskId)).fetchOne().getValue(SCHEDULED_TASK_ASSIGNER.TAG)

                val referTaskIdSequence = referTaskIds?.splitToSequence(",")

                var referTaskInstanceIds = ""
                if (null != referTaskIdSequence) {
                    for (referTaskId in referTaskIdSequence) {
                        referTaskInstanceIds += "${referTaskId}_${tag},"
                    }
                }

                // 生成实例塞库（协程）? transaction 有没有共用
                val now = DateTime.now().toString("yyyy-MM-dd HH:mm:ss")
                launch(CommonPool) {
                    create.transaction { configuration ->
                        val ctx2 = DSL.using(configuration)
                        ctx2.insertInto(TASK_INSTANCE)
                                .set(TASK_INSTANCE.TASK_INSTANCE_ID, "${taskId}_${tag}")
                                .set(TASK_INSTANCE.TASK_ID, taskId)
                                .set(TASK_INSTANCE.TASK_NAME, taskName)
                                .set(TASK_INSTANCE.TASK_CONTENT, taskContent)
                                .set(TASK_INSTANCE.PARAM, param)
                                .set(TASK_INSTANCE.TASK_TYPE, UByte.valueOf(taskType))
                                .set(TASK_INSTANCE.RETRY_TIME_THRESHOLD, retryTimeThreshold)
                                .set(TASK_INSTANCE.STATUS, UByte.valueOf(0))
                                .set(TASK_INSTANCE.RETRY, UInteger.valueOf(0))
                                .set(TASK_INSTANCE.EXECUTE_TIME, DSL.timestamp(nextTime))
                                .set(TASK_INSTANCE.CREATE_TIME, DSL.timestamp(now))
                                .set(TASK_INSTANCE.UPDATE_TIME, DSL.timestamp(now))
                                .set(TASK_INSTANCE.REFER_TASK_INSTANCE_IDS, referTaskInstanceIds.dropLast(1))
                                .onDuplicateKeyIgnore()
                                .execute()

                        ctx2.update(SCHEDULED_TASK_SKELETON)
                                .set(SCHEDULED_TASK_SKELETON.IS_INIT, UByte.valueOf(0))
                                .execute()
                    }

                }

                // 更新任务模板状态
                ctx.update(SCHEDULED_TASK_SKELETON)
                        .set(SCHEDULED_TASK_SKELETON.IS_INIT, UByte.valueOf(1))
                        .set(SCHEDULED_TASK_SKELETON.LAST_EXECUTE_TIME, DSL.timestamp(nextTime))
                        .where(SCHEDULED_TASK_SKELETON.TASK_ID.eq(taskId))
                        .execute()
            }
        }
    }
}