package com.chaos.taskcenter.executor.component.invoke

/**
 * Created by zcfrank1st on 14/06/2017.
 */
class ShellInvoke(val task: Task): Invoke {

    override fun invoke(): InvokeStatus {
        val command = listOf(task.taskContent, task.param)
        val pb = ProcessBuilder()
        pb.command(command)

        val process = pb.start()

        if (process.waitFor() == 0) {
            return InvokeStatus.SUCCESS
        } else {
            return InvokeStatus.FAILED
        }
    }
}