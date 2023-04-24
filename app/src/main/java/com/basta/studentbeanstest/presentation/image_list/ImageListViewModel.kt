package com.basta.studentbeanstest.presentation.image_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.basta.studentbeanstest.domain.models.Photo
import com.basta.studentbeanstest.domain.use_case.get_photos.GetPhotosUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ImageListViewModel(
    private val getPhotosUseCase: GetPhotosUseCase
) : ViewModel() {

    private val _state = mutableStateOf<Resource<List<Photo>>>(Resource.Loading())
    val state: State<Resource<List<Photo>>> = _state

    init {
        getPhotos()
    }

    private fun getPhotos() {
        getPhotosUseCase().onEach { result ->
            _state.value = result
        }.launchIn(viewModelScope)
    }
}