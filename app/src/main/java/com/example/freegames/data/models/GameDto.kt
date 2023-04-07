package com.example.freegames.data.models

import com.google.gson.annotations.SerializedName

/* code handly written by Petre A. Moraru, Aka: Trigger **/

data class GameDto(
    val id: Int,
    val developer: String,
    @SerializedName("freetogame_profile_url")
    val freeToGameProfileUrl: String,
    @SerializedName("game_url")
    val gameUrl: String,
    val genre: String,
    val platform: String,
    val publisher: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("short_description")
    val shortDescription: String,
    val thumbnail: String,
    val title: String
)