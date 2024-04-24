package com.example.child.controller

import com.example.bookEcommerce.utils.anotation.Sl4JLogger.Companion.log
import com.example.bookEcommerce.utils.constants.Constants
import io.micrometer.observation.annotation.Observed
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("${Constants.MAIN_URL}child")
class ChildController {

    @GetMapping
    @Observed(
        name = "user.name",
        contextualName = "child-->service",
        lowCardinalityKeyValues = ["userType", "userType2"]
    )
    fun childLog() : String{
        log.error("Child log")
        return "Child log"
    }
}