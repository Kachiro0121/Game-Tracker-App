package com.kachiro.game_api

import com.kachiro.game_api.dto.Game
import com.kachiro.game_api.dto.GameCategory

interface GameRepository {
    suspend fun getAllGames(): List<Game>
    suspend fun getGamesByCategory(listPlatform: List<String>): List<GameCategory>
}