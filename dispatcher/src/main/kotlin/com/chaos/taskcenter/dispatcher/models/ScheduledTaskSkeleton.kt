package com.chaos.taskcenter.dispatcher.models

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
        val refer: Long,
        val deployHosts: String,
        val totalRetryTimes: Int,
        val lastExecuteTime: String,
        val initStatus: Int,

        val createTime: String,
        val updateTime: String,
        val createUser: String,
        val updateUser: String
)