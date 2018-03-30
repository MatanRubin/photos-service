package com.matanrubin.photoservice.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.matanrubin.photoservice"])
class PhotoServiceApplication

fun main(args: Array<String>) {
    runApplication<PhotoServiceApplication>(*args)
}