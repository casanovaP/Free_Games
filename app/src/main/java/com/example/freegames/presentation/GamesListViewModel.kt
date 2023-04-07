package com.example.freegames.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freegames.domain.models.toGame
import com.example.freegames.domain.repository.GamesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/* code handly written by Petre A. Moraru, Aka: Trigger **/

@HiltViewModel
class GamesListViewModel @Inject constructor(
    private val gamesRepository: GamesRepository
): ViewModel() {

    private val _uiState = MutableStateFlow<GamesUiState>(GamesUiState.Loading)
    val uiState: StateFlow<GamesUiState> = _uiState.asStateFlow()

    init {
        getAllGames()
    }

    fun getAllGames() {
        viewModelScope.launch {
            try {
                val games = gamesRepository.getGames().map { it.toGame() }
                _uiState.value = GamesUiState.Success(games)

            } catch (e: IOException) {
                _uiState.value = GamesUiState.Error("Loading failed. Please check your internet connection")
            } catch(e: HttpException) {
                _uiState.value = GamesUiState.Error("Loading failed. Please check your internet connection")
            }
        }
    }
}