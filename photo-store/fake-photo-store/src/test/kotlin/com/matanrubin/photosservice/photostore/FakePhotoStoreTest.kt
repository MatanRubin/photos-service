package com.matanrubin.photosservice.photostore

import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

/**
 * @author Matan Rubin
 * @version Mar 16, 2018
 * @since Phase1
 */
class FakePhotoStoreTest {

    var photoStoreRegistry = PhotoStoreRegistry()
    var photoStore: FakePhotoStore = FakePhotoStore(photoStoreRegistry)

    @Before
    fun setUp() {
        photoStore = FakePhotoStore(photoStoreRegistry)
    }

    @Test
    fun testCreateInstance() {
        val photoName = "instance"
        val instanceId = photoStore.createInstance(photoName)
        val fetchedPhotoName = photoStore.listInstances().first()
        assertEquals(photoName, fetchedPhotoName)
    }

    @Test
    fun testDeleteInstance() {
        val photoName = "instance"
        val instanceId = photoStore.createInstance(photoName)
        assertEquals(1, photoStore.listInstances().size)
        photoStore.deleteInstance(instanceId)
        assertEquals(0, photoStore.listInstances().size)
    }
}