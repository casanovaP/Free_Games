package com.example.freegames.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.freegames.presentation.screens.GamesListScreen
import com.example.freegames.presentation.ui.theme.FreeGamesTheme
import dagger.hilt.android.AndroidEntryPoint

/* code handly written by Petre A. Moraru, Aka: Trigger **/

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val viewModel by viewModels<GamesListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FreeGamesTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    GamesListScreen(viewModel = viewModel)
                }
            }
        }
    }
}
