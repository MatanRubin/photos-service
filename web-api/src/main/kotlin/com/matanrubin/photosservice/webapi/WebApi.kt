package com.matanrubin.photosservice.webapi

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WebApi {

    @GetMapping(value = ["", "/"])
    fun helloWorld(): String {
        return "Hello, world!"
    }
}


