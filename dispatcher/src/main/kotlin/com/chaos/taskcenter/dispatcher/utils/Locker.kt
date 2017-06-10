package com.chaos.taskcenter.dispatcher.utils

import com.chaos.taskcenter.dispatcher.models.ScheduledTaskSkeleton

/**
 * Created by zcfrank1st on 10/06/2017.
 */
object Locker {
    fun lockMarkRelease(lockName: String, block: () -> List<ScheduledTaskSkeleton>) {
        try {
            lock(lockName)
            block()
        } catch (ex: Exception) {

        } finally {
            unlock(lockName)
        }
    }

    private fun unlock(lockName: String) {

    }

    private fun lock(lockName: String) {

    }
}