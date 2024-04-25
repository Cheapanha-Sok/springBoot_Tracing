package com.example.child.controller

import com.example.bookEcommerce.utils.anotation.Sl4JLogger.Companion.log
import com.example.bookEcommerce.utils.constants.Constants
import io.micrometer.observation.annotation.Observed
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("${Constants.MAIN_URL}child")
class ChildController(private val restTemplate: RestTemplate) {

    @GetMapping
    @Observed(
        name = "user.name",
        contextualName = "child-->service",
        lowCardinalityKeyValues = ["userType", "userType2"]
    )
    fun childLog() : String{
        val url : String= "http://localhost:7070/api/v1/grandChild";
        val response: ResponseEntity<String> = restTemplate.exchange(
            url,
            HttpMethod.GET,
            null,
            String::class.java
        )
        val responseFromGrandChild :String = response.body!!
        log.info("Child log")

        return responseFromGrandChild
    }
}