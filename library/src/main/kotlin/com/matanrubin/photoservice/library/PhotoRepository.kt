package com.matanrubin.photoservice.library

import java.util.*

interface PhotoRepository {
    fun save(dbPhoto: DbPhoto)
    fun delete(id: UUID)
    fun list(): List<DbPhoto>
    fun getPhotoByName(photoName: String): DbPhoto?
}

data class DbPhoto(val id: UUID, val width: Int, val height: Int, val name: String, val data: ByteArray)
