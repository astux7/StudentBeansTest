package com.basta.studentbeanstest.domain.models

import com.basta.studentbeanstest.data.remote.dto.PhotoDto

data class Photo(
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
)

fun PhotoDto.toPhoto() = Photo(
    id = id,
    thumbnailUrl = thumbnailUrl,
    title = title
)