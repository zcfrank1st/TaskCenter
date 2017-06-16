package com.chaos.taskcenter.admin.modules.task

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by zcfrank1st on 10/06/2017.
 */
@Service
class TaskService {
    @Autowired
    lateinit var taskDao: TaskDao

    fun addScheduleTask(scheduleTask: ScheduleTask) {
        taskDao.addScheduleTask(scheduleTask)
    }

    fun updateScheduleTask(scheduleTask: ScheduleTask) {
        taskDao.updateScheduleTask(scheduleTask)
    }

    fun getScheduleTasks(scheduleTaskQuery: ScheduleTaskQuery): List<ScheduleTask>? {
        return taskDao.getScheduleTasks(scheduleTaskQuery)
    }

    fun addTaskInstance(task: TaskInstance) {
        taskDao.addTaskInstance(task)
    }

    fun updateTaskInstance(task: TaskInstance) {
        taskDao.updateTaskInstance(task)
    }


    fun getTaskInstance(taskInstanceQuery: TaskInstanceQuery): List<TaskInstance>? {
        return taskDao.getTaskInstance(taskInstanceQuery)
    }
}