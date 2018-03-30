package com.matanrubin.photoservice.storage

import org.springframework.stereotype.Service
import java.util.*

@Service
class StorageBackendServiceImpl : StorageBackendService {

    override fun addStorageBackend(name: String, storageBackendMetaData: Map<String, String>): UUID {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeStorageBackend(id: UUID) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}