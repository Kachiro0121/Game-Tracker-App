package com.kachiro.game_detail.repository

import com.kachiro.game_detail.dto.GameDetail

import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(private val apiService: GameDetailApiService) : DetailRepository {

    override suspend fun gameDetail(id: Int): GameDetail? = apiService.getGameDetail(id).body()

}