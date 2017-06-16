package com.chaos.taskcenter.admin.modules.task

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 * Created by zcfrank1st on 10/06/2017.
 */
@RestController
class TaskController {
    @Autowired
    lateinit var taskService: TaskService

    @PostMapping("/schedule/task")
    fun addScheduledTask(@RequestBody scheduleTask: ScheduleTask): ResponseEntity.BodyBuilder? {
        taskService.addScheduleTask(scheduleTask)
        return ResponseEntity.ok()
    }

    @PutMapping("/schedule/task")
    fun updateScheduleTask(@RequestBody scheduleTask: ScheduleTask): ResponseEntity.BodyBuilder? {
        taskService.updateScheduleTask(scheduleTask)
        return ResponseEntity.ok()
    }

    @PostMapping("/schedule/tasks")
    fun getScheduleTasks(@RequestBody scheduleTaskQuery: ScheduleTaskQuery): ResponseEntity<List<ScheduleTask>?>? {
        return ResponseEntity.ok(taskService.getScheduleTasks(scheduleTaskQuery))
    }

    @PostMapping("/task/instance")
    fun addTaskInstance(@RequestBody task: TaskInstance): ResponseEntity.BodyBuilder? {
        taskService.addTaskInstance(task)
        return ResponseEntity.ok()
    }

    @PutMapping("/task/instance")
    fun updateTaskInstance(@RequestBody task: TaskInstance): ResponseEntity.BodyBuilder? {
        taskService.updateTaskInstance(task)
        return ResponseEntity.ok()
    }

    @PostMapping("/task/instances")
    fun getTaskInstance(@RequestBody taskInstanceQuery: TaskInstanceQuery): ResponseEntity<List<TaskInstance>?>? {
        return ResponseEntity.ok(taskService.getTaskInstance(taskInstanceQuery))
    }
}