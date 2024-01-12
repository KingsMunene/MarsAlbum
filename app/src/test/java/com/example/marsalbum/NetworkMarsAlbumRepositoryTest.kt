package com.example.marsalbum

import com.example.marsalbum.data.NetworkMarsAlbumRepositoryImplementation
import com.example.marsalbum.fake.FakeDataSource
import com.example.marsalbum.fake.FakeMarsApiService
import kotlinx.coroutines.test.runTest
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class NetworkMarsAlbumRepositoryTest {
    @Test
    fun networkMarsPhotosRepository_getMarsPhotos_verifyPhotoList() = runTest{
        val repository = NetworkMarsAlbumRepositoryImplementation(
            retrofitService = FakeMarsApiService()
        )

        assertEquals(FakeDataSource.photosList, repository.getMarsPhotos())
    }
}