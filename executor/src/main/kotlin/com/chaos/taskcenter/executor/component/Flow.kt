package com.chaos.taskcenter.executor.component

import com.chaos.taskcenter.executor.component.input.ExecuteInput
import com.chaos.taskcenter.executor.component.input.Input
import com.chaos.taskcenter.executor.component.input.RetryInput

/**
 * Created by zcfrank1st on 14/06/2017.
 */
class Flow(val input: Input): Runnable {
    override fun run() {
        // 正常执行流程
        // TODO
        // 执行是否ok
        when (input) {
            is ExecuteInput -> endExecute()
            is RetryInput -> endRetry()
            else -> throw RuntimeException("not support input!")
        }
    }

    private fun endExecute(){}
    private fun endRetry(){}

}