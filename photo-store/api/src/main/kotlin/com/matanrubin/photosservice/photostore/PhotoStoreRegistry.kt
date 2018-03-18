package com.matanrubin.photosservice.photostore

import org.springframework.stereotype.Service

@Service
class PhotoStoreRegistry {
    private var registeredPhotoStores: MutableMap<String, PhotoStore> = mutableMapOf()

    fun registerPhotoStore(name: String, photoStore: PhotoStore) {
        if (registeredPhotoStores.containsKey(name)) {
            throw IllegalArgumentException("PhotoStore with name=$name already registered")
        }
        registeredPhotoStores[name] = photoStore
    }

    fun getPhotoStore(name: String): PhotoStore {
        return registeredPhotoStores[name] ?: throw IllegalArgumentException("Unknown PhotoService with name=$name")
    }

    fun listSupportedPhotoStores(): List<SupportedPhotoStore> {
        return registeredPhotoStores.values.map(PhotoStore::getSupportedPhotoStoreInformation)
    }
}