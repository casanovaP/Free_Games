package com.example.freegames.data.remote

import com.example.freegames.data.models.GameDto
import com.example.freegames.util.Constants
import retrofit2.http.GET

/* code handly written by Petre A. Moraru, Aka: Trigger **/

interface GamesApi {
    @GET(Constants.GAMES_ENDPOINT)
    suspend fun getGames(): List<GameDto>
}