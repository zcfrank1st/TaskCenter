package com.chaos.taskcenter.dispatcher

import com.chaos.taskcenter.dispatcher.components.MysqlDispatcher

/**
 * Created by zcfrank1st on 10/06/2017.
 */


fun main(args: Array<String>) {
    while (true) {
        try {
            MysqlDispatcher.doDispatcher()
            Thread.sleep(450L)
        } catch (e : Exception) {
            // TODO log exception message
        }
    }
}