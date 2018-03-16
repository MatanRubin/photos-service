package com.matanrubin.photosservice.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.matanrubin.photosservice"])
class PhotosServiceApplication

fun main(args: Array<String>) {
    runApplication<PhotosServiceApplication>(*args)
}