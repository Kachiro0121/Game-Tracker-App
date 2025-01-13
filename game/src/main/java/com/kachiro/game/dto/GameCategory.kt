package com.kachiro.game.dto

import com.kachiro.core_api.dto.Game

data class GameCategory(
    val title: String,
    val listGame: List<Game>
)
