package com.matanrubin.photoservice.storage

data class SupportedStorageBackend(val name: String, val uri: String, val params: List<Parameter>, val icon: ByteArray) {
    data class Parameter(val uri: String, val type: Type, val displayName: String) {
        enum class Type {
            STRING,
            INTEGER,
            DOUBLE,
            PASSWORD,
            URL,
            EMAIL
        }
    }
}