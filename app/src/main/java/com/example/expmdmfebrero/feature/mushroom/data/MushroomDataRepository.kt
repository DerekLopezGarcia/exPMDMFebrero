package com.example.expmdmfebrero.feature.mushroom.data

import com.example.expmdmfebrero.feature.mushroom.domain.MushroomCard
import com.example.expmdmfebrero.feature.mushroom.domain.MushroomRepository
import org.koin.core.annotation.Single

@Single
class MushroomDataRepository(
    private val dataSource: MushroomMockDataSource
) : MushroomRepository {
    override fun getMushroomCards(albumName: String): List<MushroomCard> =
        dataSource.getMushroomCards(albumName)
}