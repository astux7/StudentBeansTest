package com.basta.studentbeanstest.domain.use_case.get_photos

import com.basta.studentbeanstest.common.Resource
import com.basta.studentbeanstest.domain.models.Photo
import com.basta.studentbeanstest.domain.models.toPhoto
import com.basta.studentbeanstest.domain.repository.PhotoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetPhotosUseCase(private val repo: PhotoRepository) {
    operator fun invoke(): Flow<Resource<List<Photo>>> = flow {
        try {
            emit(Resource.Loading())

            val photos = repo.getPhotos()

            emit(Resource.Success(photos.map { it.toPhoto() }))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Error, try later."))
        } catch (e: IOException) {
            emit(Resource.Error("Looks like you don't have internet connection."))
        }
    }

}