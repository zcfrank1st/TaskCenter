package com.chaos.taskcenter.dispatcher.components

import com.cronutils.model.CronType
import com.cronutils.model.definition.CronDefinitionBuilder
import com.cronutils.model.time.ExecutionTime
import com.cronutils.parser.CronParser
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter

/**
 * Created by zcfrank1st on 10/06/2017.
 */
class Quartz {
    private val parser = CronParser(CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ))
    private val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    fun nextExecuteTime(expression: String):String? {
        val now = ZonedDateTime.now()
        val executionTime = ExecutionTime.forCron(parser.parse(expression))
        val nextExecutionTime = executionTime.nextExecution(now)

        if (nextExecutionTime.isPresent) {
            val datetime = nextExecutionTime.get()
            return datetime.format(pattern)
        } else {
            return null
        }
    }

}