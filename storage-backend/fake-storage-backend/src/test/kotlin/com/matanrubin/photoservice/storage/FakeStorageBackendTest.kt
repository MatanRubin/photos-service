package com.matanrubin.photoservice.storage

import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

/**
 * @author Matan Rubin
 * @version Mar 16, 2018
 * @since Phase1
 */
class FakeStorageBackendTest {

    var storageBackendRegistry = StorageBackendRegistry()
    var storageBackend: FakeStorageBackend = FakeStorageBackend(storageBackendRegistry)

    @Before
    fun setUp() {
        storageBackend = FakeStorageBackend(storageBackendRegistry)
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