package com.matanrubin.photoservice.storage

import org.springframework.stereotype.Service

@Service
class StorageBackendServiceImpl(val supportedStorageBackendRegistry: SupportedStorageBackendRegistry) : StorageBackendService {

    private var storageBackends: MutableMap<String, Map<String, String>> = mutableMapOf()

    override fun listStorageBackends(): List<StorageBackendInfo> {
        return storageBackends.map { entry -> StorageBackendInfo(entry.key) }
    }

    override fun addStorageBackend(name: String, storageBackendMetaData: Map<String, String>) {
        val storageBackendApi = supportedStorageBackendRegistry.getStorageBackendApi(name)
        storageBackendApi.validateParameters(storageBackendMetaData)
        storageBackends[name] = storageBackendMetaData
    }

    override fun removeStorageBackend(name: String) {
        storageBackends.remove(name)
    }
}