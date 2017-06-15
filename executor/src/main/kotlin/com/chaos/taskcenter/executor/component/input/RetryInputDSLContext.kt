package com.chaos.taskcenter.executor.component.input

import com.chaos.taskcenter.executor.component.ApplicationConfig
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.singleton
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jooq.SQLDialect
import org.jooq.impl.DSL
import java.util.*
import javax.sql.DataSource

/**
 * Created by zcfrank1st on 14/06/2017.
 */
val retryComponents = Kodein {
    bind<DataSource>() with singleton {
        val config = HikariConfig()
        config.poolName = "retry-pool-${UUID.randomUUID().toString().replace("-", "")}"
        config.jdbcUrl = ApplicationConfig.conf.getString("taskcenter.executor.db.url")
        config.username = ApplicationConfig.conf.getString("taskcenter.executor.db.username")
        config.password = ApplicationConfig.conf.getString("taskcenter.executor.db.password")
        HikariDataSource(config)
    }
}


object RetryInputDSLContext: InputDSLContext {
    override val datasource: DataSource = retryComponents.instance()

    override val context
        get() = DSL.using(datasource, SQLDialect.MYSQL)
}