package com.example.marsalbum.network

import retrofit2.http.GET

interface MarsAlbumApiService {
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>

}