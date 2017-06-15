package com.chaos.taskcenter.executor.component.invoke

/**
 * Created by zcfrank1st on 14/06/2017.
 */
data class Task (
        val taskInstanceId: String,
        val taskContent: String,
        val param: String,
        val taskType: Int
)