package com.matanrubin.photosservice.photostore

import java.util.*

interface PhotoStore {

    fun createInstance(photoName: String): UUID

    fun deleteInstance(id: UUID)

    fun listInstances(): MutableCollection<String>

    fun getName(): String

    fun getSupportedPhotoStoreInformation(): SupportedPhotoStore
}


