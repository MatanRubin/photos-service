package com.matanrubin.photoservice.storage

import org.springframework.stereotype.Component
import java.util.*
import javax.annotation.PostConstruct

@Component
class DropboxStorageBackendApi(val supportedStorageBackendRegistry: SupportedStorageBackendRegistry) : StorageBackendApi {

    private val name = "Dropbox"
    private val uri = "dropboxStorageBackend"
    private var instances: MutableMap<UUID, String> = mutableMapOf()

    private val supportedStorageBackendInfo = SupportedStorageBackend(
            name,
            uri,
            listOf(
                    SupportedStorageBackend.Parameter(
                            "email",
                            SupportedStorageBackend.Parameter.Type.STRING,
                            "Email"),
                    SupportedStorageBackend.Parameter(
                            "password",
                            SupportedStorageBackend.Parameter.Type.PASSWORD,
                            "Password")
            ),
            ClassLoader.getSystemResource("Dropbox.png").readBytes()
    )

    @PostConstruct
    fun registerStorageBackend() {
        supportedStorageBackendRegistry.registerSupportedStorageBackend(name, this)
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

    override fun getSupportedStorageBackendInfo(): SupportedStorageBackend {
        return supportedStorageBackendInfo
    }

    override fun validateParameters(storageBackendMetaData: Map<String, String>) {
        val parameterNames = supportedStorageBackendInfo.params.map { x -> x.uri }
        storageBackendMetaData.forEach { x ->
            if (!parameterNames.contains(x.key)) {
                throw IllegalArgumentException("Parameter with uri='${x.key}' not supported for storage backend '$name'")
            }
        }
    }
}

