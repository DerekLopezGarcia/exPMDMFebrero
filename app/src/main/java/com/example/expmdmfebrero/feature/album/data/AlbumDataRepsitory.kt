package com.example.expmdmfebrero.feature.album.data

import com.example.expmdmfebrero.feature.album.domain.Album
import com.example.expmdmfebrero.feature.album.domain.AlbumRepository
import org.koin.core.annotation.Single

@Single
class AlbumDataRepository(
    private val dataSource: AlbumMockDataSource
) : AlbumRepository {
    private val favoriteAlbums = mutableSetOf<String>()

    override fun getAllAlbums(): List<Album> = dataSource.getAlbums()

    override fun getFavoriteAlbums(): List<Album> =
        dataSource.getAlbums().filter { favoriteAlbums.contains(it.name) }

    override fun toggleFavorite(albumName: String) {
        if (favoriteAlbums.contains(albumName)) {
            favoriteAlbums.remove(albumName)
        } else {
            favoriteAlbums.add(albumName)
        }
    }

    override fun isFavorite(albumName: String): Boolean =
        favoriteAlbums.contains(albumName)
}