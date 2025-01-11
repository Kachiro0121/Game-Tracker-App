package com.kachiro.game_detail.repository

import com.kachiro.game_detail.dto.GameDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GameDetailApiService {
    @GET("game")
    suspend fun getGameDetail(@Query("id") id: Int): Response<GameDetail>
}