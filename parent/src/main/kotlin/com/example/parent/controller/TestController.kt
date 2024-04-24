package com.example.parent.controller

import com.example.bookEcommerce.utils.anotation.Sl4JLogger
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
@RequestMapping("${Constants.MAIN_URL}parent")
@Sl4JLogger
class TestController(private val restTemplate: RestTemplate) {

    @GetMapping
    @Observed(
        name = "user.name",
        contextualName = "parent-->child",
        lowCardinalityKeyValues = ["userType", "userType2"]
    )
    fun home(): String {
        val url : String= "http://localhost:9090/api/v1/child";
        val response: ResponseEntity<String> = restTemplate.exchange(
            url,
            HttpMethod.GET,
            null,
            String::class.java
        )
        val responseFromGrandChild :String = response.body!!
        log.info("Parent log")

        return responseFromGrandChild
    }
}