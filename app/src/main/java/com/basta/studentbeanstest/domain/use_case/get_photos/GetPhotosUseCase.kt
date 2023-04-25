package com.basta.studentbeanstest.domain.use_case.get_photos

import com.basta.studentbeanstest.presentation.image_list.Resource
import com.basta.studentbeanstest.domain.models.Photo
import com.basta.studentbeanstest.domain.models.toPhoto
import com.basta.studentbeanstest.domain.repository.PhotoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetPhotosUseCase(private val repository: PhotoRepository) {
    operator fun invoke(): Flow<Resource<List<Photo>>> = flow {
        emit(Resource.Loading())
        val result = repository.getPhotos()
        result.onSuccess { photos ->
            emit(Resource.Success(photos.map { it.toPhoto() }))
        }.onFailure { e ->
            emit(Resource.Error(message = e.toMessage()))
        }
    }
}

fun Throwable.toMessage() = when (this) {
    is HttpException -> this.localizedMessage ?: "Error, try later."
    is IOException -> "Looks like you don't have internet connection."
    else -> "Try again later"
}