package com.chaos.taskcenter.dispatcher.components

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
        val referTaskId: Long,
        val retryTimeThreshold: Int,
        val lastExecuteTime: String,

        val createTime: String,
        val updateTime: String,
        val createUser: String,
        val updateUser: String
)

data class TaskInstance(
        val taskInstanceId: String,
        val taskId: Long,
        val taskName: String,
        val taskContent: String,
        val param: String,
        val taskType: Int,
        val referTaskInstanceId: String,
        val retryTimeThreshold: Int,

        val createTime: String,
        val updateTime: String,

        val status: Int,
        val retryTimes: Int,
        val executeTime: String
)

data class TaskLock(
        val lockName: String
)

class DBOperator {
    fun doOperator() {

    }

    private fun retrieveNeedInitTaskSkeletons(): List<ScheduledTaskSkeleton>? {

        return null
    }

    private fun initTaskInstances() {}

    private fun lock() {}

    private fun unlock() {}
}