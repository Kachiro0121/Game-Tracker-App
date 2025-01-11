package com.kachiro.core_api.dto

data class GameResponse(
    val id: Int,
    val title: String,
    val genre: String,
    val thumbnail: String
)