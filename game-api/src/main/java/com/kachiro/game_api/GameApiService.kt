package com.kachiro.game_api

import com.kachiro.game_api.dto.Game
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GameApiService {
    @GET("games")
    suspend fun getAllGames(): Response<List<Game>>

    @GET("games")
    suspend fun getGamesPlatform(@Query("platform") platform: String): Response<List<Game>>
}