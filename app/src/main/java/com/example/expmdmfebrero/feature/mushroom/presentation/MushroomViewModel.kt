package com.example.expmdmfebrero.feature.mushroom.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expmdmfebrero.core.ErrorApp
import com.example.expmdmfebrero.feature.mushroom.domain.GetMushroomCardsUseCase
import com.example.expmdmfebrero.feature.mushroom.domain.MushroomCard
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class MushroomViewModel(private val getMushroomCardsUseCase: GetMushroomCardsUseCase) : ViewModel() {
    private val _uiState = MutableLiveData(UiState())
    val uiState: LiveData<UiState> = _uiState

    fun loadMushroomCards(albumName: String) {
        val mushroomCards = getMushroomCardsUseCase(albumName)
        val randomMushrooms = mushroomCards.shuffled().take(5)
        viewModelScope.launch {
            _uiState.value = UiState(
                isLoading = false,
                mushroomCards = randomMushrooms,
                error = null
            )
        }
    }
}
data class UiState(
    val isLoading: Boolean = false,
    val mushroomCards: List<MushroomCard> = emptyList(),
    val error: ErrorApp? = null
)