package com.chaos.taskcenter.dispatcher.components

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.select

/**
 * Created by zcfrank1st on 10/06/2017.
 */
object ScheduledTaskSkeleton: Table() {
    val taskId = long("task_id").autoIncrement().primaryKey()
    val taskName = varchar("task_name", length = 64)
    val quartzExpression = varchar("quartz_expression", length = 20)
    val taskContent = text("task_content")
    val param = text("param")
    val taskType = integer("task_type")
    val refer = long("refer")
    val deployHosts = text("deploy_hosts")
    val totalRetryTimes = integer("total_retry_times")
    val lastExecuteTime = varchar("last_execute_time", length = 20)

    val createTime = varchar("create_time", length = 20)
    val updateTime = varchar("update_time", length = 20)
    val createUser = varchar("create_user", length = 20)
    val updateUser = varchar("update_user", length = 20)
}

object TaskInstance: Table() {
    val taskInstanceId = long("task_instance_id").autoIncrement().primaryKey()
    val taskId = long("task_id")
    val taskName = varchar("task_name", length = 64)
    val taskContent = text("task_content")
    val param = text("param")
    val taskType = integer("task_type")
    val refer = long("refer")
    val deployHosts = text("deploy_hosts")
    val totalRetryTimes = integer("total_retry_times")

    val createTime = varchar("create_time", length = 20)
    val updateTime = varchar("update_time", length = 20)

    val status = integer("status")
    val retryTimes = integer("retry_times")
    val executeTime = varchar("create_time", length = 20)
}

object TaskLock: Table() {
    val lockName = varchar("lock_name", length = 64)
    val status = integer("status")
}

class DBOperator {

    fun initInstance() {}

    fun retrieveNeedInitSkeletons(): List<ScheduledTaskSkeleton>? {
        Database.connect("jdbc:h2:mem:test", driver = "org.h2.Driver")
        println ("hello world")

        return null
    }

    private fun lock() {}

}