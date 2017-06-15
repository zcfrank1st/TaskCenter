package com.chaos.taskcenter.executor.component.input

import org.jooq.DSLContext
import javax.sql.DataSource

/**
 * Created by zcfrank1st on 14/06/2017.
 */
interface InputDSLContext {
    val datasource: DataSource
    val context: DSLContext
}