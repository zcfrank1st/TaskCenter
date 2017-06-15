package com.chaos.taskcenter.executor

import com.chaos.taskcenter.executor.component.Flow
import com.chaos.taskcenter.executor.component.input.ExecuteInput
import com.chaos.taskcenter.executor.component.input.RetryInput
import java.util.concurrent.Executors

/**
 * Created by zcfrank1st on 10/06/2017.
 */
fun main(args: Array<String>) {

    val retryExecutor = Executors.newFixedThreadPool(10)
    val executeExecutor = Executors.newFixedThreadPool(10)

    while (true) {
        executeExecutor.execute(Flow(ExecuteInput))
        retryExecutor.execute(Flow(RetryInput))

        Thread.sleep(800L)
    }
}