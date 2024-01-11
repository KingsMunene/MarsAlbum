package com.example.marsalbum.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marsalbum.data.MarsAlbumRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class MarsAlbumViewModel @Inject constructor(
    private val repository: MarsAlbumRepository
): ViewModel() {
    var marsAlbumUiState: MarsAlbumUiState by mutableStateOf(MarsAlbumUiState.Loading)
        private set

    init {
        getMarsPhotos()
    }

    private fun getMarsPhotos() {
        viewModelScope.launch {
            try {
                val result = repository.getMarsPhotos()
                marsAlbumUiState = MarsAlbumUiState.Success(
                    "Success: ${result.size} photos have been retrieved"
                )
            }catch (e: IOException){
                marsAlbumUiState = MarsAlbumUiState.Error
            }
        }
    }
}