package com.example.expmdmfebrero.feature.mushroom.domain

import org.koin.core.annotation.Single

@Single
class GetMushroomCardsUseCase(private val repository: MushroomRepository) {
    operator fun invoke(albumName: String): List<MushroomCard> =
        repository.getMushroomCards(albumName)
}