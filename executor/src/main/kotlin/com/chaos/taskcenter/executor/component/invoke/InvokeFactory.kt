package com.chaos.taskcenter.executor.component.invoke

/**
 * Created by zcfrank1st on 14/06/2017.
 */
class InvokeFactory(val task: Task) {

    inline fun <reified T> generate():Invoke {
        return when(T::class.simpleName) {
            HttpInvoke::class.simpleName -> HttpInvoke(task)
            ShellInvoke::class.simpleName -> ShellInvoke(task)
            else -> throw RuntimeException("not support invoke!")
        }
    }
}