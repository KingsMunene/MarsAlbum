package com.example.marsalbum.fake

import com.example.marsalbum.network.MarsAlbumApiService
import com.example.marsalbum.network.MarsPhoto

class FakeMarsApiService : MarsAlbumApiService {
    override suspend fun getPhotos(): List<MarsPhoto> = FakeDataSource.photosList

}