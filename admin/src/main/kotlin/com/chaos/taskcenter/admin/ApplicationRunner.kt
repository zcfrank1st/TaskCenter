package com.chaos.taskcenter.admin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * Created by zcfrank1st on 10/06/2017.
 */
@SpringBootApplication
class ApplicationRunner

fun main(args: Array<String>) {
    SpringApplication.run(ApplicationRunner::class.java,  *args)
}