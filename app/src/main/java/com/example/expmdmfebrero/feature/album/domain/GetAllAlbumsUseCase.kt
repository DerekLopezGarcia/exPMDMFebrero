package com.example.expmdmfebrero.feature.album.domain

import org.koin.core.annotation.Single

@Single
class GetAllAlbumsUseCase(private val repository: AlbumRepository) {
    operator fun invoke(onlyFavorites: Boolean = false): List<Album> =
        if (onlyFavorites) repository.getFavoriteAlbums()
        else repository.getAllAlbums()

    fun toggleFavorite(albumName: String) = repository.toggleFavorite(albumName)
    fun isFavorite(albumName: String): Boolean = repository.isFavorite(albumName)
}