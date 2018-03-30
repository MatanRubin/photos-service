package com.matanrubin.photoservice.storage

import org.springframework.stereotype.Service
import java.util.*

@Service
interface StorageBackendService {

    fun addStorageBackend(name: String, storageBackendMetaData: Map<String, String>): UUID

    fun removeStorageBackend(id: UUID)
}