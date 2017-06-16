
package com.chaos.taskcenter.admin.modules.script

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

/**
 * Created by zcfrank1st on 15/06/2017.
 */
@RestController
class ScriptController {
    @Autowired
    lateinit var scriptService: ScriptService
}