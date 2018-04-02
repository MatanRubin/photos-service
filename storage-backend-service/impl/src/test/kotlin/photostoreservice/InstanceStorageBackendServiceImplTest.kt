
import com.matanrubin.photoservice.storage.StorageBackendServiceImpl
import com.matanrubin.photoservice.storage.SupportedStorageBackendRegistry
import org.junit.Test

class StorageBackendApiServiceImplTest {

    val supportedStorageBackendRegistry = SupportedStorageBackendRegistry()
    var storageBackendService = StorageBackendServiceImpl(supportedStorageBackendRegistry)

    @Test
    fun listSupportedStorageBackends() {
    }
}