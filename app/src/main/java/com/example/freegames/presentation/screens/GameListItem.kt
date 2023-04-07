package com.example.freegames.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.freegames.domain.models.Game

/* code handly written by Petre A. Moraru, Aka: Trigger **/

@Composable
fun GameCard(
    game: Game,
) {
    Card(
        elevation = CardDefaults.cardElevation(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        shape = MaterialTheme.shapes.medium,
    ) {
        Column(
            modifier = Modifier,
            Arrangement.Center,
            Alignment.CenterHorizontally,
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(game.thumbnail)
                    .crossfade(true)
                    .build(),
                contentDescription = "${game.title} image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.clip(
                    RoundedCornerShape(8.dp)
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = game.title)
            Text(text = game.developer)
            Text(text = game.genre)
            Text(text = game.platform)
            Text(text = game.publisher)
            Text(text = game.releaseDate)
            Text(text = game.shortDescription)
            Text(text = game.gameUrl)
        }
    }
}
