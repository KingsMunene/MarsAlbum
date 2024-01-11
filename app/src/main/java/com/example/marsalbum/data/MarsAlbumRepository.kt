package com.example.marsalbum.data

import com.example.marsalbum.network.MarsPhoto

// Repository
interface MarsAlbumRepository {
    suspend fun  getMarsPhotos(): List<MarsPhoto>
}