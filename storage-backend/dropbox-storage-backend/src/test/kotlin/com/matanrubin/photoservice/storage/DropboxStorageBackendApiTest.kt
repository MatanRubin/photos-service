package com.matanrubin.photoservice.storage

import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class DropboxStorageBackendApiTest {

    var storageBackendRegistry = SupportedStorageBackendRegistry()
    var storageBackend: DropboxStorageBackendApi = DropboxStorageBackendApi(storageBackendRegistry)

    @Before
    fun setUp() {
        storageBackend = DropboxStorageBackendApi(storageBackendRegistry)
    }

    @Test
    fun testStore() {
        val data = "my data"
        val id = storageBackend.store(data)
        val loadedData = storageBackend.load(id)
        assertEquals(data, loadedData)
    }

    @Test
    fun testDelete() {
        val id = storageBackend.store("data")
        assertEquals(1, storageBackend.list().size)
        storageBackend.delete(id)
        assertEquals(0, storageBackend.list().size)
    }
}