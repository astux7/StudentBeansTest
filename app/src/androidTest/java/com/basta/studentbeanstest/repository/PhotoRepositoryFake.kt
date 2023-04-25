package com.basta.studentbeanstest.repository

import com.basta.studentbeanstest.data.remote.dto.PhotoDto
import com.basta.studentbeanstest.domain.repository.PhotoRepository

class PhotoRepositoryFake(private var shouldReturnError: Boolean = false) : PhotoRepository {
    private val photoList = listOf(
        PhotoDto(
            1,
            1,
            url = "https://via.placeholder.com/600/92c952",
            thumbnailUrl = "https://via.placeholder.com/150/92c952",
            title = "accusamus beatae ad facilis cum similique qui sunt"
        ),
        PhotoDto(
            1,
            2,
            thumbnailUrl = "https://via.placeholder.com/150/771796",
            title = "reprehenderit est deserunt velit ipsam",
            url = "https://via.placeholder.com/600/771796",
        ),
        PhotoDto(
            1,
            3,
            thumbnailUrl = "https://via.placeholder.com/150/24f355",
            title = "officia porro iure quia iusto qui ipsa ut modi",
            url = "https://via.placeholder.com/600/24f355"
        ),
    )

    override suspend fun getPhotos(): Result<List<PhotoDto>> {
        return if (shouldReturnError) {
            Result.failure(Throwable())
        } else {
            Result.success(photoList)
        }
    }
}