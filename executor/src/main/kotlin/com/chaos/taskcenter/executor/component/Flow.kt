package com.chaos.taskcenter.executor.component

import com.chaos.taskcenter.executor.component.input.ExecuteInputDSLContext
import com.chaos.taskcenter.executor.component.input.InputDSLContext
import com.chaos.taskcenter.executor.component.input.RetryInputDSLContext
import com.chaos.taskcenter.executor.component.invoke.*
import com.chaos.taskcenter.jooq.generated.Tables.TASK_INSTANCE
import com.chaos.taskcenter.jooq.generated.Tables.TASK_LOCK
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch
import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.Result
import org.jooq.impl.DSL
import org.jooq.types.UByte

/**
 * Created by zcfrank1st on 14/06/2017.
 */
class Flow(val inCtx: InputDSLContext): Runnable {
    override fun run() {

        //执行流程
        val ctx = inCtx.context
        var tasks: List<Task>? = null
        ctx.transaction { configuration ->
            val transactionCtx = DSL.using(configuration)

            when (inCtx) {
                is ExecuteInputDSLContext -> {
                    transactionCtx.select().from(TASK_LOCK).where(TASK_LOCK.LOCK_NAME.eq("EXECUTOR_LOCK")).forUpdate().fetch()

                    val res = transactionCtx.select()
                            .from(TASK_INSTANCE)
                            .where(TASK_INSTANCE.STATUS.eq(UByte.valueOf(0)))
                            .and("execute_time <= now()")
                            .fetch()

                    tasks = buildTasks(res, transactionCtx)
                }
                is RetryInputDSLContext -> {
                    transactionCtx.select().from(TASK_LOCK).where(TASK_LOCK.LOCK_NAME.eq("CLEANER_LOCK")).forUpdate().fetch()

                    val res = transactionCtx.select()
                            .from(TASK_INSTANCE)
                            .where(TASK_INSTANCE.STATUS.eq(UByte.valueOf(2)))
                            .and(TASK_INSTANCE.RETRY.lessThan(TASK_INSTANCE.RETRY_TIME_THRESHOLD))
                            .fetch()

                    tasks = buildTasks(res, transactionCtx)
                }
                else -> throw RuntimeException("no such context!")
            }
        }
        flow(tasks, ctx)
    }

    private fun buildTasks(res: Result<Record>, transactionCtx: DSLContext): List<Task> {
        val tasks = mutableListOf<Task>()
        for (r in res) {
            val refers = r.getValue(TASK_INSTANCE.REFER_TASK_INSTANCE_IDS)
            if (!refers.isNullOrBlank()) {
                val referListIds = refers.split(",")

                val resultList = mutableListOf<Boolean>()
                for (referId in referListIds) {
                    val refer = transactionCtx.select()
                            .from(TASK_INSTANCE)
                            .where(TASK_INSTANCE.TASK_INSTANCE_ID.eq(referId))
                            .fetchOne()

                    if (refer.getValue(TASK_INSTANCE.STATUS).toInt() == 2) resultList.add(true) else resultList.add(false)
                }

                if (!resultList.all { it }) continue
            }

            val taskInstanceId = r.getValue(TASK_INSTANCE.TASK_INSTANCE_ID)
            tasks.add(Task(
                    taskInstanceId,
                    r.getValue(TASK_INSTANCE.TASK_CONTENT),
                    r.getValue(TASK_INSTANCE.PARAM),
                    r.getValue(TASK_INSTANCE.TASK_TYPE).toInt()
            ))

            transactionCtx.update(TASK_INSTANCE)
                    .set(TASK_INSTANCE.STATUS, UByte.valueOf(1))
                    .where(TASK_INSTANCE.TASK_INSTANCE_ID.eq(taskInstanceId))
                    .execute()

        }

        return tasks
    }

    private fun flow(res: List<Task>?, ctx: DSLContext) {
        if (null != res) {
            for (record in res) {
                launch(CommonPool) {
                    var status: InvokeStatus = InvokeStatus.INIT
                    when (record.taskType) {
                        0 -> status = InvokeFactory(record).generate<HttpInvoke>().invoke()
                        1 -> status = InvokeFactory(record).generate<ShellInvoke>().invoke()
                        else -> throw RuntimeException("not support invoke!")
                    }

                    when (status) {
                        InvokeStatus.SUCCESS -> ctx.update(TASK_INSTANCE).set(TASK_INSTANCE.STATUS, UByte.valueOf(2)).where(TASK_INSTANCE.TASK_INSTANCE_ID.eq(record.taskInstanceId))
                        InvokeStatus.FAILED -> ctx.update(TASK_INSTANCE).set(TASK_INSTANCE.STATUS, UByte.valueOf(3)).where(TASK_INSTANCE.TASK_INSTANCE_ID.eq(record.taskInstanceId))
                        else -> throw RuntimeException("not support invoke status!")
                    }
                }
            }
        }
    }
}