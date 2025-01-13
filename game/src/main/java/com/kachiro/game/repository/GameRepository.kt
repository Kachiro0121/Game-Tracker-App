package com.kachiro.game.repository

import com.kachiro.core_api.dto.Game
import com.kachiro.game.dto.GameCategory

interface GameRepository {
    suspend fun getAllGames(): List<Game>
    suspend fun getGamesByCategory(listPlatform: List<String>): List<GameCategory>
}