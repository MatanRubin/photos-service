package com.matanrubin.photoservice.library

interface PhotoLibrary {
    fun list(): List<PhotoLibraryPhoto>
    fun getPhotoByName(name: String): PhotoLibraryPhoto

}

data class PhotoLibraryPhoto()
