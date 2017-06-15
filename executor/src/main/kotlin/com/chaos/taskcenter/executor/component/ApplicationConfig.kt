package com.chaos.taskcenter.executor.component

import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory

/**
 * Created by zcfrank1st on 15/06/2017.
 */
class ApplicationConfig {
    companion object {
        val conf: Config = ConfigFactory.load()
    }
}