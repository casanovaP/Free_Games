package com.example.freegames.domain.models

import com.example.freegames.data.models.GameDto

/* code handly written by Petre A. Moraru, Aka: Trigger **/

data class Game(
    val id: Int,
    val developer: String,
    val gameUrl: String,
    val genre: String,
    val platform: String,
    val publisher: String,
    val releaseDate: String,
    val shortDescription: String,
    val thumbnail: String,
    val title: String
)

fun GameDto.toGame(): Game {
    return Game(
        id = id,
        developer = developer,
        gameUrl = gameUrl,
        genre = genre,
        platform = platform,
        publisher = publisher,
        releaseDate = releaseDate,
        shortDescription = shortDescription,
        thumbnail = thumbnail,
        title = title
    )
}
