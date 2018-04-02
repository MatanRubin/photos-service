package com.matanrubin.photoservice.library

import java.util.*

interface PhotoRepository {
    fun save(dbPhoto: DbPhoto)
    fun delete(id: UUID)
    fun list(): List<DbPhoto>
}

data class DbPhoto(val id: UUID, val width: Long, val height: Long, val name: String, val data: ByteArray)
