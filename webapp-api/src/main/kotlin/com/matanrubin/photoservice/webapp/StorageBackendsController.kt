package com.matanrubin.photoservice.webapp

import com.matanrubin.photoservice.storage.StorageBackendService
import com.matanrubin.photoservice.storage.SupportedStorageBackend
import com.matanrubin.photoservice.storage.SupportedStorageBackendRegistry
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class StorageBackendsController(
        private val supportedStorageBackendRegistry: SupportedStorageBackendRegistry,
        private val storageBackendService: StorageBackendService) {

    @GetMapping("/supported-storage-backends")
    fun listSupportedStorageBackends(): List<UiSupportedStorageBackend> {
        return supportedStorageBackendRegistry
                .listSupportedStorageBackends()
                .map { x -> UiSupportedStorageBackend(x.name, x.uri, x.params.map(::convertParameter)) }
    }

    @GetMapping("/storage-backends")
    fun listStorageBackends(): List<UiStorageBackendInfo> {
        return storageBackendService.listStorageBackends().map { x -> UiStorageBackendInfo(x.name, "") }
    }

    @PostMapping("/commands/add-storage-backend")
    fun addStorageBackend(@RequestBody addStorageBackendRequest: UiAddStorageBackendRequest) {
        storageBackendService.addStorageBackend(addStorageBackendRequest.name, addStorageBackendRequest.parameters)
    }

    @PostMapping("/commands/remove-storage-backend")
    fun removeStorageBackend(@RequestBody removeStorageBackendRequest: UiRemoveStorageBackendRequest) {
        storageBackendService.removeStorageBackend(removeStorageBackendRequest.name)
    }
}

data class UiAddStorageBackendRequest(val name: String, val parameters: Map<String, String>)
data class UiRemoveStorageBackendRequest(val name: String)
data class UiSupportedStorageBackend(val name: String, val uri: String, val parameters: List<Parameter>) {
    data class Parameter(val uri: String, val type: Type, val displayName: String) {
        enum class Type {
            STRING,
            INTEGER,
            DOUBLE,
            PASSWORD,
            URL,
            EMAIL;
        }
    }
}

// TODO fix this
data class UiStorageBackendInfo(val name: String, val metadataParameters: String)

fun convertParameter(param: SupportedStorageBackend.Parameter): UiSupportedStorageBackend.Parameter {
    val type = when (param.type) {
        SupportedStorageBackend.Parameter.Type.STRING -> UiSupportedStorageBackend.Parameter.Type.STRING
        SupportedStorageBackend.Parameter.Type.INTEGER -> UiSupportedStorageBackend.Parameter.Type.INTEGER
        SupportedStorageBackend.Parameter.Type.DOUBLE -> UiSupportedStorageBackend.Parameter.Type.DOUBLE
        SupportedStorageBackend.Parameter.Type.PASSWORD -> UiSupportedStorageBackend.Parameter.Type.PASSWORD
        SupportedStorageBackend.Parameter.Type.URL -> UiSupportedStorageBackend.Parameter.Type.URL
        SupportedStorageBackend.Parameter.Type.EMAIL -> UiSupportedStorageBackend.Parameter.Type.EMAIL
    }

    return UiSupportedStorageBackend.Parameter(param.uri, type, param.displayName)
}


