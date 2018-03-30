package com.matanrubin.photoservice.storage

import org.springframework.stereotype.Component
import java.util.*
import javax.annotation.PostConstruct

@Component
class FakeStorageBackend(val storageBackendRegistry: StorageBackendRegistry) : StorageBackend {

    private val name = "FakeStorageBackend"
    private var instances: MutableMap<UUID, String> = mutableMapOf()
    private val supportedStorageBackendInfo = SupportedStorageBackendInfo(
            name,
            listOf(
                    SupportedStorageBackendInfo.MetaDataParam(
                            "url",
                            SupportedStorageBackendInfo.MetaDataParam.Type.URL,
                            "Service URL"),
                    SupportedStorageBackendInfo.MetaDataParam(
                            "username",
                            SupportedStorageBackendInfo.MetaDataParam.Type.STRING,
                            "Username"),
                    SupportedStorageBackendInfo.MetaDataParam(
                            "password",
                            SupportedStorageBackendInfo.MetaDataParam.Type.PASSWORD,
                            "Password")
            )
    )

    @PostConstruct
    fun registerStorageBackend() {
        storageBackendRegistry.registerStorageBackend(name, this)
    }

    override fun store(data: String): UUID {
        val id = UUID.randomUUID()
        instances[id] = data
        return id
    }

    override fun load(id: UUID): String {
        return instances[id] ?: throw IllegalArgumentException("No object with id=$id")
    }

    override fun delete(id: UUID) {
        instances.remove(id)
    }

    override fun list(): Map<UUID, String> {
        return instances
    }

    override fun getStorageBackendName(): String {
        return name
    }

    override fun getSupportedStorageBackendInfo(): SupportedStorageBackendInfo {
        return supportedStorageBackendInfo
    }

}


