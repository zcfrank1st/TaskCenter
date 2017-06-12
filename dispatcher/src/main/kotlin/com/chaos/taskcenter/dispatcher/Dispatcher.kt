package com.chaos.taskcenter.dispatcher

import com.chaos.taskcenter.dispatcher.components.DBOperator
import com.chaos.taskcenter.dispatcher.components.Quartz
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton

/**
 * Created by zcfrank1st on 10/06/2017.
 */
val components = Kodein {
    bind<Quartz>() with singleton { Quartz() }
    bind<DBOperator>() with singleton { DBOperator() }
}


class Dispatcher(private val components: Kodein) {
    private val quartz: Quartz = components.instance()
    private val operator: DBOperator = components.instance()


    fun dispatcher() {
        // TODO
        // lock
        // retrieve
        // init instance(co) and update skeleton
        //  unlock
    }
}


fun main(args: Array<String>) {
    while (true) {
        Dispatcher(components).dispatcher()
        Thread.sleep(300L)
    }
}