package com.matanrubin.photoservice.storage


data class StorageBackendInfo(val name: String)

interface StorageBackendService {

    fun addStorageBackend(name: String, storageBackendMetaData: Map<String, String>)

    fun removeStorageBackend(name: String)

    fun listStorageBackends(): List<StorageBackendInfo>
}