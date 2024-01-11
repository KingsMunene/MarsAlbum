package com.example.marsalbum.data

import com.example.marsalbum.network.MarsAlbumApiService
import com.example.marsalbum.network.MarsPhoto

class NetworkMarsAlbumRepositoryImplementation(
    private val retrofitService: MarsAlbumApiService
): MarsAlbumRepository{
    override suspend fun getMarsPhotos(): List<MarsPhoto> = retrofitService.getPhotos()
}