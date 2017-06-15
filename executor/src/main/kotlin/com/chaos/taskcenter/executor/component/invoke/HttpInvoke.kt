package com.chaos.taskcenter.executor.component.invoke

/**
 * Created by zcfrank1st on 14/06/2017.
 */
class HttpInvoke(val task: Task) : Invoke {
    override fun invoke(): InvokeStatus {
        // TODO
        return InvokeStatus.SUCCESS
    }
}