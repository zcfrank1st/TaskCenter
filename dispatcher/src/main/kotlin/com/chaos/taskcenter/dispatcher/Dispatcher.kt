package com.chaos.taskcenter.dispatcher

import com.chaos.taskcenter.dispatcher.components.DispatcherOperator
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton

/**
 * Created by zcfrank1st on 10/06/2017.
 */
val components = Kodein {
    bind<DispatcherOperator>() with singleton { DispatcherOperator() }
}


class Dispatcher(components: Kodein) {
    private val operator: DispatcherOperator = components.instance()

    fun dispatcher() {
        operator.doDispatcher()
    }
}


fun main(args: Array<String>) {
    while (true) {
        try {
            Dispatcher(components).dispatcher()
            Thread.sleep(300L)
        } catch (e : Exception) {
            // TODO
        }
    }
}