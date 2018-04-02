package com.matanrubin.photoservice.storage

import java.util.*

interface StorageBackendApi {

    fun store(data: String): UUID

    fun load(id: UUID): String

    fun delete(id: UUID)

    fun list(): Map<UUID, String>

    fun getStorageBackendName(): String

    fun getSupportedStorageBackendInfo(): SupportedStorageBackend

    fun validateParameters(storageBackendMetaData: Map<String, String>)
}


