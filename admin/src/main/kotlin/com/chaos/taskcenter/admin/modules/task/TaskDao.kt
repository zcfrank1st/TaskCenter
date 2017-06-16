package com.chaos.taskcenter.admin.modules.task

import org.springframework.stereotype.Repository

/**
 * Created by zcfrank1st on 10/06/2017.
 */
@Repository
class TaskDao {

    fun addScheduleTask(scheduleTask: ScheduleTask) {

    }

    fun updateScheduleTask(scheduleTask: ScheduleTask) {
        // TODO
    }

    fun getScheduleTasks(scheduleTaskQuery: ScheduleTaskQuery): List<ScheduleTask>? {
        // TODO 分页
        return null
    }

    fun addTaskInstance(task: TaskInstance) {
        // TODO
    }

    fun updateTaskInstance(task: TaskInstance) {
        // TODO
    }


    fun getTaskInstance(taskInstanceQuery: TaskInstanceQuery): List<TaskInstance>? {
        // TODO 分页
        return null
    }
}