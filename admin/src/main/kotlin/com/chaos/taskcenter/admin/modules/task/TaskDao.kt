package com.chaos.taskcenter.admin.modules.task

import com.chaos.taskcenter.jooq.generated.Tables.SCHEDULED_TASK_SKELETON
import com.chaos.taskcenter.jooq.generated.Tables.TASK_INSTANCE
import org.joda.time.DateTime
import org.jooq.DSLContext
import org.jooq.types.UByte
import org.jooq.types.UInteger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.sql.Timestamp

/**
 * Created by zcfrank1st on 10/06/2017.
 */
@Repository
class TaskDao {
    @Autowired
    lateinit var dslContext: DSLContext

    fun addScheduleTask(scheduleTask: ScheduleTask) {
        val now = DateTime.now().toString("yyyy-MM-dd HH:mm:ss")
        dslContext
                .insertInto(SCHEDULED_TASK_SKELETON)
                .set(SCHEDULED_TASK_SKELETON.TASK_NAME, scheduleTask.taskName)
                .set(SCHEDULED_TASK_SKELETON.QUARTZ_EXPRESSION, scheduleTask.quartzExpression)
                .set(SCHEDULED_TASK_SKELETON.TASK_CONTENT, scheduleTask.taskContent)
                .set(SCHEDULED_TASK_SKELETON.PARAM, scheduleTask.param)
                .set(SCHEDULED_TASK_SKELETON.TASK_TYPE, UByte.valueOf(scheduleTask.taskType))
                .set(SCHEDULED_TASK_SKELETON.RETRY_TIME_THRESHOLD, UInteger.valueOf(scheduleTask.retryTimeThreshold))
                .set(SCHEDULED_TASK_SKELETON.CREATE_TIME, Timestamp.valueOf(now))
                .set(SCHEDULED_TASK_SKELETON.UPDATE_TIME, Timestamp.valueOf(now))
                .set(SCHEDULED_TASK_SKELETON.REFER_TASK_IDS, scheduleTask.referTaskIds)
                .set(SCHEDULED_TASK_SKELETON.IS_INIT, UByte.valueOf(0))
                .set(SCHEDULED_TASK_SKELETON.IS_VALID, UByte.valueOf(0))
                .execute()
    }

    fun updateScheduleTask(scheduleTask: ScheduleTask) {
        val now = DateTime.now().toString("yyyy-MM-dd HH:mm:ss")
        dslContext
                .update(SCHEDULED_TASK_SKELETON)
                .set(SCHEDULED_TASK_SKELETON.TASK_NAME, scheduleTask.taskName)
                .set(SCHEDULED_TASK_SKELETON.QUARTZ_EXPRESSION, scheduleTask.quartzExpression)
                .set(SCHEDULED_TASK_SKELETON.TASK_CONTENT, scheduleTask.taskContent)
                .set(SCHEDULED_TASK_SKELETON.PARAM, scheduleTask.param)
                .set(SCHEDULED_TASK_SKELETON.TASK_TYPE, UByte.valueOf(scheduleTask.taskType))
                .set(SCHEDULED_TASK_SKELETON.RETRY_TIME_THRESHOLD, UInteger.valueOf(scheduleTask.retryTimeThreshold))
                .set(SCHEDULED_TASK_SKELETON.UPDATE_TIME, Timestamp.valueOf(now))
                .set(SCHEDULED_TASK_SKELETON.REFER_TASK_IDS, scheduleTask.referTaskIds)
                .set(SCHEDULED_TASK_SKELETON.IS_INIT, UByte.valueOf(0))
                .set(SCHEDULED_TASK_SKELETON.IS_VALID, UByte.valueOf(scheduleTask.isValid))
                .execute()
    }

    fun getScheduleTasks(scheduleTaskQuery: ScheduleTaskQuery): List<ScheduleTask>? {
        // TODO 分页
        return null
    }

    fun addTaskInstance(task: TaskInstance) {
        val now = DateTime.now().toString("yyyy-MM-dd HH:mm:ss")
        dslContext
                .insertInto(TASK_INSTANCE)
                .set(TASK_INSTANCE.TASK_ID, UInteger.valueOf(task.taskId))
                .set(TASK_INSTANCE.TASK_NAME, task.taskName)
                .set(TASK_INSTANCE.TASK_CONTENT, task.taskContent)
                .set(TASK_INSTANCE.PARAM, task.param)
                .set(TASK_INSTANCE.TASK_TYPE, UByte.valueOf(task.taskType))
                .set(TASK_INSTANCE.RETRY_TIME_THRESHOLD, UInteger.valueOf(task.retryTimeThreshold))
                .set(TASK_INSTANCE.CREATE_TIME, Timestamp.valueOf(now))
                .set(TASK_INSTANCE.UPDATE_TIME, Timestamp.valueOf(now))
                .set(TASK_INSTANCE.REFER_TASK_INSTANCE_IDS, task.referTaskInstanceIds)
                .set(TASK_INSTANCE.STATUS, UByte.valueOf(0))
                .execute()
    }

    fun updateTaskInstance(task: TaskInstance) {
        val now = DateTime.now().toString("yyyy-MM-dd HH:mm:ss")
        dslContext
                .insertInto(TASK_INSTANCE)
                .set(TASK_INSTANCE.TASK_NAME, task.taskName)
                .set(TASK_INSTANCE.TASK_CONTENT, task.taskContent)
                .set(TASK_INSTANCE.PARAM, task.param)
                .set(TASK_INSTANCE.TASK_TYPE, UByte.valueOf(task.taskType))
                .set(TASK_INSTANCE.RETRY_TIME_THRESHOLD, UInteger.valueOf(task.retryTimeThreshold))
                .set(TASK_INSTANCE.UPDATE_TIME, Timestamp.valueOf(now))
                .set(TASK_INSTANCE.REFER_TASK_INSTANCE_IDS, task.referTaskInstanceIds)
                .set(TASK_INSTANCE.STATUS, UByte.valueOf(task.status))
                .execute()
    }


    fun getTaskInstance(taskInstanceQuery: TaskInstanceQuery): List<TaskInstance>? {
        // TODO 分页
        return null
    }
}