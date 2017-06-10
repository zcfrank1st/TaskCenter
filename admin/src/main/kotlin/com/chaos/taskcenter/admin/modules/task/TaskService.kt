package com.chaos.taskcenter.admin.modules.task

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created by zcfrank1st on 10/06/2017.
 */
@Service
class TaskService {
    @Autowired
    lateinit var taskDao: TaskDao


}