package com.example.freegames.domain.repository

import com.example.freegames.data.models.GameDto

/* code handly written by Petre A. Moraru, Aka: Trigger **/

interface GamesRepository {
    suspend fun getGames(): List<GameDto>
}