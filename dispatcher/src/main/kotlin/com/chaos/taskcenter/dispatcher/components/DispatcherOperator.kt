package com.chaos.taskcenter.dispatcher.components

import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton

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
}

class DispatcherOperator {
    private val quartz: Quartz = components.instance()

    fun doDispatcher(tag: String) {
        // TODO
    }

    private fun retrieveNeedInitTaskSkeletons() {}

    private fun initTaskInstances() {}

    private fun dispatcherLock() {}

    private fun dispatcherUnlock() {}


}