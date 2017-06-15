package com.chaos.taskcenter.executor.component.input

import javax.sql.DataSource

/**
 * Created by zcfrank1st on 14/06/2017.
 */
interface Input {
    val datasource: DataSource
    fun load()
}