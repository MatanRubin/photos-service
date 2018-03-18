package com.matanrubin.photosservice.webapp

import com.matanrubin.photosservice.photostore.PhotoStoreRegistry
import com.matanrubin.photosservice.photostore.SupportedPhotoStore
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WebappApi(private val photoStoreRegistry: PhotoStoreRegistry) {

    @GetMapping("/supported-stores")
    fun listSupportedStores(): List<SupportedPhotoStore> {
        return photoStoreRegistry.listSupportedPhotoStores()
    }
}


