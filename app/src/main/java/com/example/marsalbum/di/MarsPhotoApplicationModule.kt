package com.example.marsalbum.di

import com.example.marsalbum.data.MarsAlbumRepository
import com.example.marsalbum.data.NetworkMarsAlbumRepositoryImplementation
import com.example.marsalbum.network.MarsAlbumApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MarsPhotoApplicationModule {

    private val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com"
    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(baseUrl)
            .build()
    }

    @Provides
    @Singleton
    fun providesRetrofitService(retrofit: Retrofit): MarsAlbumApiService{
        return retrofit.create(MarsAlbumApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesMarsAlbumRepository(retrofitService: MarsAlbumApiService): MarsAlbumRepository{
        return NetworkMarsAlbumRepositoryImplementation(retrofitService)
    }
}