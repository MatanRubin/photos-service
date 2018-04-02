package com.matanrubin.photoservice.webapp

import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class LibraryController {

    @GetMapping("/photos")
    fun listPhotos(): List<UiPhoto> {
        return emptyList()
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
data class UiPhoto(val id: UUID, val height: Int, val width: Int, val name: String, val bytes: ByteArray)
