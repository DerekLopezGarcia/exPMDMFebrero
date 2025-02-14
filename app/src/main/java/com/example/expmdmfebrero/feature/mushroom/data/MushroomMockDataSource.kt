package com.example.expmdmfebrero.feature.mushroom.data

import com.example.expmdmfebrero.feature.mushroom.domain.MushroomCard
import org.koin.core.annotation.Single

@Single
class MushroomMockDataSource {
    fun getMushroomCards(albumName: String): List<MushroomCard> = listOf(
        MushroomCard("Amanita Muscaria", "https://example.com/img1.jpg"),
        MushroomCard("Boletus Edulis", "https://example.com/img2.jpg"),
        MushroomCard("Cantharellus Cibarius", "https://example.com/img3.jpg"),
        MushroomCard("Clitocybe Nuda", "https://example.com/img4.jpg"),
        MushroomCard("Coprinus Comatus", "https://example.com/img5.jpg"),
        MushroomCard("Craterellus Cornucopioides", "https://example.com/img6.jpg"),
        MushroomCard("Gyromitra Esculenta", "https://example.com/img7.jpg"),
        MushroomCard("Hydnum Repandum", "https://example.com/img8.jpg"),
        MushroomCard("Lactarius Deliciosus", "https://example.com/img9.jpg"),
        MushroomCard("Morchella Esculenta", "https://example.com/img10.jpg"),
    )
}