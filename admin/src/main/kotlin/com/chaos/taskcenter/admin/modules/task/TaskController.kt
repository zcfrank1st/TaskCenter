package com.chaos.taskcenter.admin.modules.task

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

/**
 * Created by zcfrank1st on 10/06/2017.
 */
@RestController
class TaskController {
    @Autowired
    lateinit var taskService: TaskService


}