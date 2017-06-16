package com.chaos.taskcenter.admin.modules


import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.impl.DSL
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*
import javax.sql.DataSource

/**
 * Created by zcfrank1st on 15/06/2017.
 */
@Configuration
class ApplicationConfig {
    @Bean
    fun config(): Config {
        return ConfigFactory.load()
    }

    @Bean
    fun datasource(): DataSource {
        val config = HikariConfig()
        config.poolName = "admin-pool-${UUID.randomUUID().toString().replace("-", "")}"
        config.jdbcUrl  = config().getString("taskcenter.admin.db.url")
        config.username = config().getString("taskcenter.admin.db.username")
        config.password = config().getString("taskcenter.admin.db.password")
        return HikariDataSource(config)
    }

    @Bean
    fun dslContext(): DSLContext {
        return DSL.using(datasource(), SQLDialect.MYSQL)
    }
}