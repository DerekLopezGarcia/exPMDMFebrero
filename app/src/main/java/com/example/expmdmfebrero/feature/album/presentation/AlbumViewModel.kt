package com.example.expmdmfebrero.feature.album.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expmdmfebrero.core.ErrorApp
import com.example.expmdmfebrero.feature.album.domain.Album
import com.example.expmdmfebrero.feature.album.domain.GetAllAlbumsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class AlbumViewModel(private val getAllAlbumsUseCase: GetAllAlbumsUseCase) : ViewModel() {
    private val _uiState = MutableLiveData(UiState())
    val uiState: LiveData<UiState> = _uiState
    private var showOnlyFavorites = false

    fun isShowingOnlyFavorites() = showOnlyFavorites


    fun loadAlbums() {
        val albums = getAllAlbumsUseCase(showOnlyFavorites)
        viewModelScope.launch {
            _uiState.value = UiState(
                isLoading = false,
                albums = albums,
                error = null
            )
        }
    }

    fun toggleFavorite(albumName: String) {
        getAllAlbumsUseCase.toggleFavorite(albumName)
        loadAlbums()
    }

    fun toggleFavoriteFilter() {
        showOnlyFavorites = !showOnlyFavorites
        loadAlbums()
    }

    fun isFavorite(albumName: String): Boolean =
        getAllAlbumsUseCase.isFavorite(albumName)
}
data class UiState(
    val isLoading: Boolean = false,
    val albums: List<Album> = emptyList(),
    val error: ErrorApp? = null
)