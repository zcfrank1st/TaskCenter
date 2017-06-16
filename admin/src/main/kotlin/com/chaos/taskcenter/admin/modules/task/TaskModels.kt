package com.chaos.taskcenter.admin.modules.task

/**
 * Created by zcfrank1st on 16/06/2017.
 */

data class ScheduleTask(
        val taskId: Long,
        val taskName: String,
        val quartzExpression: String,
        val taskContent: String,
        val param: String,
        val taskType: Int,
        val retryTimeThreshold: Int,
        val createTime: String,
        val updateTime: String,
        val referTaskIds: String,
        val isInit: Int,
        val isValid: Int
)

data class TaskInstance(
        val taskInstanceId: String,
        val taskName: String,
        val taskId: Long,
        val taskContent: String,
        val param: String,
        val taskType: Int,
        val retryTimeThreshold: Int,
        val status: Int,
        val executeTime: String,
        val createTime: String,
        val updateTime: String,
        val referTaskInstanceIds: String
)

data class ScheduleTaskQuery(
        val taskName: String,
        val taskType: Int,
        val isValid: Int,
        val startTime: String,
        val endTime: String,
        val current: Int,
        val limit: Int
)

data class TaskInstanceQuery(
        val taskName: String,
        val taskType: Int,
        val status: Int,
        val startTime: String,
        val endTime: String,
        val current: Int,
        val limit: Int
)