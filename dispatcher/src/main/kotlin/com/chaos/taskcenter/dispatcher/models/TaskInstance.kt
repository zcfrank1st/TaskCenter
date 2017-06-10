package com.chaos.taskcenter.dispatcher.models

/**
 * Created by zcfrank1st on 10/06/2017.
 */
data class TaskInstance(
        val taskInstanceId: Long,
        val taskId: Long,
        val taskName: String,
        val taskContent: String,
        val taskParam: String,
        val taskType: Int,
        val refer: Long,
        val deployHosts: String,
        val totalRetryTimes: Int,

        val status: Int,
        val retryTimes: Int,

        val createTime: String,
        val updateTime: String
)