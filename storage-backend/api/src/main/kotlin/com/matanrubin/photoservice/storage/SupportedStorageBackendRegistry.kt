package com.matanrubin.photoservice.storage

import org.springframework.stereotype.Service

@Service
class SupportedStorageBackendRegistry {
    private var supportedStorageBackendsApi: MutableMap<String, StorageBackendApi> = mutableMapOf()

    fun registerSupportedStorageBackend(name: String, storageBackendApi: StorageBackendApi) {
        if (supportedStorageBackendsApi.containsKey(name)) {
            throw IllegalArgumentException("StorageBackendApi with name=$name already registered")
        }

        supportedStorageBackendsApi[name] = storageBackendApi
    }

    fun getStorageBackendApi(name: String): StorageBackendApi {
        return supportedStorageBackendsApi[name]
                ?: throw IllegalArgumentException("StorageBackend with name='$name' not supported")
    }

    fun listSupportedStorageBackends(): List<SupportedStorageBackend> {
        return supportedStorageBackendsApi.values.map(StorageBackendApi::getSupportedStorageBackendInfo)
    }
}