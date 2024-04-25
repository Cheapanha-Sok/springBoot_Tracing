package com.example.Grand_Child.controller

import com.example.Grand_Child.utils.anotation.Sl4JLogger.Companion.log
import com.example.Grand_Child.utils.constants.Constants
import io.micrometer.observation.annotation.Observed
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("${Constants.MAIN_URL}grandChild")
class GrandChildController {

    @GetMapping
    @Observed(
        name = "user.name",
        contextualName = "grandChild-->service",
        lowCardinalityKeyValues = ["userType", "userType2"]
    )
    fun grandChildLog() : String{
        log.error("Grand Child log")
        return "Grand Child log"
    }
}