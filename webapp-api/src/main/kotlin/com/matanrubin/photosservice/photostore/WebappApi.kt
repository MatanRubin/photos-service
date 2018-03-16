package com.matanrubin.photosservice.photostore

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WebappApi {

    @GetMapping(value = ["", "/"])
    fun helloWorld(): String {
        return "Hello, world!"
    }
}


