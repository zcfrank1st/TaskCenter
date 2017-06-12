package com.chaos.taskcenter.dispatcher.components

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jooq.SQLDialect
import org.jooq.impl.DSL
import javax.sql.DataSource

/**
 * Created by zcfrank1st on 10/06/2017.
 */
data class ScheduledTaskSkeleton(
        val taskId: Long,
        val taskName: String,
        val quartzExpression: String,
        val taskContent: String,
        val param: String,
        val taskType: Int,
        val retryTimeThreshold: Int,
        val lastExecuteTime: String,

        val createTime: String,
        val updateTime: String,
        val createUser: String,
        val updateUser: String,

        val referTaskIds: String
)

data class TaskInstance(
        val taskInstanceId: String,
        val taskId: Long,
        val taskName: String,
        val taskContent: String,
        val param: String,
        val taskType: Int,
        val retryTimeThreshold: Int,

        val status: Int,
        val retry: Int,
        val executeTime: String,

        val createTime: String,
        val updateTime: String,

        val referTaskInstanceIds: String
)

data class TaskLock(
        val lockName: String
)

val components = Kodein {
    bind<Quartz>() with singleton { Quartz() }
    bind<DataSource>() with singleton {
        val config = HikariConfig()
        config.jdbcUrl = "jdbc:mysql://192.168.33.219:3306/task_center"
        config.username = "djdev"
        config.password = "djDev123456;"
        HikariDataSource(config)
    }
}

class DispatcherOperator {
    private val dataSource: DataSource = components.instance()
    private val quartz: Quartz = components.instance()

    fun doDispatcher(tag: String) {
        // TODO
    }

    private fun retrieveNeedInitTaskSkeletons() {}

    private fun initTaskInstances() {
        // insert ignore into task_instance (task_instance_id, task_name) values ('abcdefg_121', '12121')
    }

    private fun dispatcherLock() {
        val create = DSL.using(dataSource, SQLDialect.MYSQL)

    }

    private fun dispatcherUnlock() {
        val create = DSL.using(dataSource, SQLDialect.MYSQL)

    }


}