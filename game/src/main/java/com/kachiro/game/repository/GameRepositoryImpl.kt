package com.kachiro.game.repository

import com.kachiro.core_api.dto.Game
import com.kachiro.game.dto.GameCategory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext

import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(private val apiService: GameApiService) : GameRepository {

    override suspend fun getAllGames(): List<Game> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getAllGames()
            if (response.isSuccessful) {
                response.body() ?: emptyList()
            } else {
                throw Exception("Failed to load games: ${response.message()}")
            }
        }
    }

    override suspend fun getGamesByCategory(listPlatform: List<String>): List<GameCategory> {
        return withContext(Dispatchers.IO) {
            coroutineScope {
                val deferredResponses = listPlatform.map { platform ->
                    async {
                        val response = apiService.getGamesPlatform(platform)
                        if (response.isSuccessful) {
                            response.body()?.let { games -> GameCategory(platform.uppercase(), games) }
                        } else {
                            throw Exception("Failed to load games: ${response.message()}")
                        }
                    }
                }
                deferredResponses.awaitAll().filterNotNull()
            }
        }
    }
}