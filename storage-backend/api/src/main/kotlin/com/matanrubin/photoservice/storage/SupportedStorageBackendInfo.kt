package com.matanrubin.photoservice.storage

class SupportedStorageBackendInfo(val name: String, val params: List<MetaDataParam>) {
    class MetaDataParam(val name: String, val type: Type, description: String) {
        enum class Type {
            STRING,
            URL,
            PASSWORD
        }
    }
}