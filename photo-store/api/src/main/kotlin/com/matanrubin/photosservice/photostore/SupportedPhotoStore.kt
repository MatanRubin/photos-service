package com.matanrubin.photosservice.photostore

class SupportedPhotoStore(val name: String, val params: List<MetaDataParam>) {
    class MetaDataParam(val name: String, val type: Type, description: String) {
        enum class Type {
            STRING,
            URL,
            PASSWORD
        }
    }
}