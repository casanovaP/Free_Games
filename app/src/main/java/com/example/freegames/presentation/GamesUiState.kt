package com.example.freegames.presentation

import com.example.freegames.domain.models.Game

/* code handly written by Petre A. Moraru, Aka: Trigger **/

sealed class GamesUiState {
    object Loading : GamesUiState()
    data class Success(val data: List<Game>) : GamesUiState()
    data class Error(val message: String) : GamesUiState()
}