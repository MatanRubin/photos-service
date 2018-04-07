package com.matanrubin.photoservice.webapp

import com.matanrubin.photoservice.library.DbPhoto
import com.matanrubin.photoservice.library.PhotoRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import java.util.*

@Controller
class FileUploadController(val photoRepository: PhotoRepository) {

    @PostMapping("/upload")
    fun handleFileUpload(@RequestParam("file") file: MultipartFile, redirectAttributes: RedirectAttributes) : String {
        val dbPhoto = DbPhoto(UUID.randomUUID(), 100, 100, file.originalFilename ?: "", file.bytes)
        photoRepository.save(dbPhoto)
        return "redirect:/"
    }

}
