package com.matanrubin.photoservice.library

import org.springframework.stereotype.Repository
import java.util.*

@Repository
internal class PhotoRepositoryInMemoryImpl : PhotoRepository {
    override fun getPhotoByName(photoName: String): DbPhoto? {
        return photos.values.firstOrNull { x -> x.name == photoName }
    }

    var photos: MutableMap<UUID, DbPhoto> = mutableMapOf()

    override fun save(dbPhoto: DbPhoto) {
        photos[dbPhoto.id] = dbPhoto
    }

    override fun delete(id: UUID) {
        photos.remove(id)
    }

    override fun list(): List<DbPhoto> {
        return photos.values.toList()
    }
}