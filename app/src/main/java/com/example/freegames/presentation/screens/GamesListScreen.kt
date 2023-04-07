package com.example.freegames.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.freegames.presentation.GamesListViewModel
import com.example.freegames.presentation.GamesUiState

/* code handly written by Petre A. Moraru, Aka: Trigger **/

@Composable
fun GamesListScreen(
    viewModel: GamesListViewModel
) {
   val state by viewModel.uiState.collectAsState()

    when(state) {
        is GamesUiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is GamesUiState.Success -> {
            val data = (state as GamesUiState.Success).data
            LazyColumn {
                items(data) { item ->
                    GameCard(game = item)
                }
            }
        }

        is GamesUiState.Error -> {
            val message = (state as GamesUiState.Error).message

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center

            ) {
                Text(text = message)
            }
        }
    }
}