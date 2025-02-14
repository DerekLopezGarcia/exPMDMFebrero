package com.example.expmdmfebrero.feature.album.data

import com.example.expmdmfebrero.feature.album.domain.Album
import org.koin.core.annotation.Single

@Single
class AlbumMockDataSource {
    fun getAlbums(): List<Album> = listOf(
        Album("Setas Comestibles 2024", "01/01/2024", "Colección de setas comestibles", "https://example.com/img1.jpg"),
        Album("Setas Venenosas 1", "15/01/2024", "Guía de setas peligrosas", "https://example.com/img2.jpg"),
        Album("Setas Medicinales", "30/01/2024", "Setas con propiedades curativas", "https://example.com/img3.jpg"),
        Album("Setas Alucinógenas", "15/02/2024", "Setas con efectos psicotrópicos", "https://example.com/img4.jpg"),
        Album("Setas Comestibles 2023", "01/01/2023", "Colección de setas comestibles", "https://example.com/img5.jpg"),
        Album("Setas Venenosas 2", "15/01/2023", "Guía de setas peligrosas", "https://example.com/img6.jpg"),
        Album("Setas Medicinales", "30/01/2023", "Setas con propiedades curativas", "https://example.com/img7.jpg"),
        Album("Setas Alucinógenas", "15/02/2023", "Setas con efectos psicotrópicos", "https://example.com/img8.jpg"),
        Album("Setas Comestibles 2022", "01/01/2022", "Colección de setas comestibles", "https://example.com/img9.jpg"),
        Album("Setas Venenosas 3", "15/01/2022", "Guía de setas peligrosas", "https://example.com/img10.jpg"),
        Album("Setas Medicinales", "30/01/2022", "Setas con propiedades curativas", "https://example.com/img11.jpg")
    )
}