package com.matanrubin.photoservice.storage

data class SupportedStorageBackend(val name: String, val params: List<Parameter>) {
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