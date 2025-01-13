package com.kachiro.game_catalog.repository

import com.kachiro.core_api.dto.Game

interface Repository {
    suspend fun getGames(): List<Game>?
    suspend fun getGamesByFilters(filter: List<String>?): List<Game>?
}