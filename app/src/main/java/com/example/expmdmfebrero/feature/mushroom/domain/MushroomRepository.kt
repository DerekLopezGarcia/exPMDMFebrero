package com.example.expmdmfebrero.feature.mushroom.domain

interface MushroomRepository {
    fun getMushroomCards(albumName: String): List<MushroomCard>
}