package com.example.expmdmfebrero.feature.album.domain

interface AlbumRepository {
    fun getAllAlbums(): List<Album>
    fun getFavoriteAlbums(): List<Album>
    fun toggleFavorite(albumName: String)
    fun isFavorite(albumName: String): Boolean
}