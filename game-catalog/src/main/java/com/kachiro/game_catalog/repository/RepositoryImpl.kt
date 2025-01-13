package com.kachiro.game_catalog.repository

import com.kachiro.core_api.dto.Game
import okhttp3.internal.platform.Platform

import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: CatalogApiService) : Repository {

    override suspend fun getGames(): List<Game>? = apiService.getGames().body()

    override suspend fun getGamesByFilters(filter: List<String>?): List<Game>? = apiService.getGamesByFilters(filter).body()
}