package com.example.marsalbum.ui.screens

sealed class MarsAlbumUiState {
    data class Success(val photo: String): MarsAlbumUiState()
    object Error: MarsAlbumUiState()
    object Loading: MarsAlbumUiState()
}