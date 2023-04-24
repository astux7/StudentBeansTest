package com.basta.studentbeanstest.data.repository

import com.basta.studentbeanstest.data.remote.PhotoApi
import com.basta.studentbeanstest.data.remote.dto.PhotoDto
import com.basta.studentbeanstest.domain.repository.PhotoRepository

class PhotoRepositoryImpl(private val api: PhotoApi) : PhotoRepository {
    override suspend fun getPhotos(): List<PhotoDto> {
        return api.getPhotos()
    }
}