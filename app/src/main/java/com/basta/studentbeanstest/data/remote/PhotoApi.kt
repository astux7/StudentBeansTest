package com.basta.studentbeanstest.data.remote

import com.basta.studentbeanstest.data.remote.dto.PhotoDto
import retrofit2.http.GET

interface PhotoApi {
    @GET("/photos")
    suspend fun getPhotos(): List<PhotoDto>
}