package com.chaos.taskcenter.dispatcher

import com.chaos.taskcenter.dispatcher.components.DispatcherOperator
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import java.util.*

/**
 * Created by zcfrank1st on 10/06/2017.
 */
val components = Kodein {
    bind<DispatcherOperator>() with singleton { DispatcherOperator() }
}


class Dispatcher(components: Kodein, val tag: String) {
    private val operator: DispatcherOperator = components.instance()

    fun dispatcher() {
        operator.doDispatcher(tag)
    }
}


fun main(args: Array<String>) {
    while (true) {
        try {
            val uuid = UUID.randomUUID().toString().replace("-", "")
            Dispatcher(components, uuid).dispatcher()
            Thread.sleep(300L)
        } catch (e : Exception) {
            // TODO log exception message
        }
    }
}