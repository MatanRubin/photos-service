package com.matanrubin.photosservice.photostore

import java.util.*

class ShpanPhotoStore: PhotoStore {

    private var instances: MutableMap<UUID, String> = mutableMapOf()

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

}


