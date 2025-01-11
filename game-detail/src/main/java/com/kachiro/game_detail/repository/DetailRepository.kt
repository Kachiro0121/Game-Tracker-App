package com.kachiro.game_detail.repository

import com.kachiro.game_detail.dto.GameDetail

interface DetailRepository {
    suspend fun gameDetail(id: Int): GameDetail?
}