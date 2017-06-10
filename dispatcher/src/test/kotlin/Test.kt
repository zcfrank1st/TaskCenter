import com.cronutils.model.CronType
import com.cronutils.model.definition.CronDefinitionBuilder
import com.cronutils.model.time.ExecutionTime
import com.cronutils.parser.CronParser
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter


/**
 * Created by zcfrank1st on 10/06/2017.
 */
fun main(args: Array<String>) {
    val cronDefinition = CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ)
    val parser = CronParser(cronDefinition)

    val now = ZonedDateTime.now()
    val executionTime = ExecutionTime.forCron(parser.parse("0 0/5 * 1/1 * ? *"))

    val nextExecutionTime = executionTime.nextExecution(now)


    if (nextExecutionTime.isPresent) {
        val datetime = nextExecutionTime.get()
        println(datetime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
    }
}
