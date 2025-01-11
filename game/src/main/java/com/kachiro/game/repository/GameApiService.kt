package com.kachiro.game.repository

import com.kachiro.game.dto.Game
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GameApiService {
    @GET("games")
    suspend fun getAllGames(): Response<List<Game>>

    @GET("games")
    suspend fun getGamesPlatform(@Query("platform") platform: String): Response<List<Game>>
}