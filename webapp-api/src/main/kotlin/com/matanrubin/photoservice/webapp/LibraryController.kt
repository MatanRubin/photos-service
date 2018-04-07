package com.matanrubin.photoservice.webapp

import com.matanrubin.photoservice.library.DbPhoto
import com.matanrubin.photoservice.library.PhotoRepository
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class LibraryController(val photoRepository: PhotoRepository) {

    @GetMapping("/photos")
    fun listPhotos(): List<UiPhoto> {
        return photoRepository
                .list()
                .map { x -> UiPhoto(x.id, x.height, x.width, x.name, x.data.size, "/photos/${x.name}") }
    }

    @GetMapping("photos/{photoName}", produces = [MediaType.IMAGE_JPEG_VALUE])
    fun getPhoto(@PathVariable("photoName") photoName: String) : ByteArray {
        val photo = photoRepository.getPhotoByName(photoName) ?: throw IllegalArgumentException("No photo with name='$photoName'")
        return photo.data
    }

    @PostMapping("/commands/upload-photo")
    fun uploadPhoto(@RequestBody uiUploadPhoto: UiUploadPhoto): UUID {
        return UUID.randomUUID()
    }

    @DeleteMapping("commands/delete-photo")
    fun deletePhoto(@RequestBody id: UUID) {

    }
}

data class UiUploadPhoto(val name: String, val bytes: ByteArray)
data class UiPhoto(val id: UUID, val height: Int, val width: Int, val name: String, val size: Int, val url: String)
