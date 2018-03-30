package com.matanrubin.photoservice.storage

import java.util.*

interface StorageBackend {

    fun store(data: String): UUID

    fun load(id: UUID): String

    fun delete(id: UUID)

    fun list(): Map<UUID, String>

    fun getStorageBackendName(): String

    fun getSupportedStorageBackendInfo(): SupportedStorageBackendInfo
}


