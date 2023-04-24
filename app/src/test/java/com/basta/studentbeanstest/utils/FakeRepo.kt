package com.basta.studentbeanstest.utils

import com.basta.studentbeanstest.data.remote.dto.PhotoDto
import com.basta.studentbeanstest.domain.repository.PhotoRepository

class FakeRepo : PhotoRepository {

    private val photoList = mutableListOf<PhotoDto>()

    private val photo1 = PhotoDto(
        albumId = 1,
        id = 1,
        title = "accusamus beatae ad facilis cum similique qui sunt",
        url = "https://via.placeholder.com/600/92c952",
        thumbnailUrl = "https://via.placeholder.com/150/92c952"
    )

    private val photo2 = PhotoDto(
        albumId = 1,
        id = 2,
        title = "reprehenderit est deserunt velit ipsam",
        url = "https://via.placeholder.com/600/771796",
        thumbnailUrl = "https://via.placeholder.com/150/771796"
    )

    init {
        photoList.addAll(listOf(photo1, photo2))
    }

    override suspend fun getPhotos(): List<PhotoDto> {
        return photoList.toList()
    }
}
