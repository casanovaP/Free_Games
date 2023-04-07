package com.example.freegames.data.repository

import com.example.freegames.data.models.GameDto
import com.example.freegames.data.remote.GamesApi
import com.example.freegames.domain.repository.GamesRepository
import javax.inject.Inject

/* code handly written by Petre A. Moraru, Aka: Trigger **/

class GamesRepositoryImpl @Inject constructor(
    private val api: GamesApi
): GamesRepository {
    override suspend fun getGames(): List<GameDto> {
        return api.getGames()
    }
}