package com.matanrubin.photoservice.webapp

import com.matanrubin.photoservice.storage.StorageBackendRegistry
import com.matanrubin.photoservice.storage.SupportedStorageBackendInfo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WebappApi(private val storageBackendRegistry: StorageBackendRegistry) {

    @GetMapping("/supported-storage-backends")
    fun listSupportedStorageBackends(): List<SupportedStorageBackendInfo> {
        return storageBackendRegistry.listSupportedStorageBackends()
    }
}


