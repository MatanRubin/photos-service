package com.matanrubin.photosservice.photostoreservice

import org.springframework.stereotype.Service
import java.util.*

@Service
interface PhotoStoreService {

    fun addPhotoStore(name: String, photoStoreMetaData: Map<String, String>): UUID

    fun removePhotoStore(id: UUID)
}