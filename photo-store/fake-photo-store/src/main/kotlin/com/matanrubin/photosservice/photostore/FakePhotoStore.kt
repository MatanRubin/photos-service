package com.matanrubin.photosservice.photostore

import org.springframework.stereotype.Component
import java.util.*
import javax.annotation.PostConstruct

@Component
class FakePhotoStore(val photoStoreRegistry: PhotoStoreRegistry) : PhotoStore {

    private val name = "FakePhotoStore"
    private var instances: MutableMap<UUID, String> = mutableMapOf()
    private val supportedPhotoStore = SupportedPhotoStore(
            name,
            listOf(
                    SupportedPhotoStore.MetaDataParam(
                            "url",
                            SupportedPhotoStore.MetaDataParam.Type.URL,
                            "Service URL"),
                    SupportedPhotoStore.MetaDataParam(
                            "username",
                            SupportedPhotoStore.MetaDataParam.Type.STRING,
                            "Username"),
                    SupportedPhotoStore.MetaDataParam(
                            "password",
                            SupportedPhotoStore.MetaDataParam.Type.PASSWORD,
                            "Password")
            )
    )

    @PostConstruct
    fun registerPhotoStore() {
        photoStoreRegistry.registerPhotoStore(name, this)
    }

    override fun createInstance(photoName: String): UUID {
        val id = UUID.randomUUID()
        instances[id] = photoName
        return id
    }

    override fun deleteInstance(id: UUID) {
        instances.remove(id)
    }

    override fun listInstances(): MutableCollection<String> {
        return instances.values
    }

    override fun getName(): String {
        return name
    }

    override fun getSupportedPhotoStoreInformation(): SupportedPhotoStore {
        return supportedPhotoStore
    }

}


