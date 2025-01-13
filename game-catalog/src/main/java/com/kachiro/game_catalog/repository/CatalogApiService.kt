package com.kachiro.game_catalog.repository

import com.kachiro.core_api.dto.Game
import okhttp3.internal.platform.Platform
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CatalogApiService {
    @GET("games")
    suspend fun getGames(): Response<List<Game>>

    @GET("filter")
    suspend fun getGamesByFilters(@Query("tag") filter: List<String>?): Response<List<Game>>
}