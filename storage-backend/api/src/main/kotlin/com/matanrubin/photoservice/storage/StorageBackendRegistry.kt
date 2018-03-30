package com.matanrubin.photoservice.storage

import org.springframework.stereotype.Service

@Service
class StorageBackendRegistry {
    private var registeredStorageBackends: MutableMap<String, StorageBackend> = mutableMapOf()

    fun registerStorageBackend(name: String, storageBackend: StorageBackend) {
        if (registeredStorageBackends.containsKey(name)) {
            throw IllegalArgumentException("StorageBackend with name=$name already registered")
        }
        registeredStorageBackends[name] = storageBackend
    }

    fun getStorageBackend(name: String): StorageBackend {
        return registeredStorageBackends[name] ?: throw IllegalArgumentException("Unknown StorageBackend name=$name")
    }

    fun listSupportedStorageBackends(): List<SupportedStorageBackendInfo> {
        return registeredStorageBackends.values.map(StorageBackend::getSupportedStorageBackendInfo)
    }
}