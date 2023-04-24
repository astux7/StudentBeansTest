package com.basta.studentbeanstest.domain.repository

import com.basta.studentbeanstest.data.remote.dto.PhotoDto

interface PhotoRepository {
    suspend fun getPhotos() : List<PhotoDto>
}
