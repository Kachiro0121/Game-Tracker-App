package com.kachiro.game_catalog.dto

import com.kachiro.game_catalog.R

enum class Filters {
    MMORPG,
    SHOOTER,
    STRATEGY,
    MOBA;

    val title get() = when(this){
        MMORPG -> R.string.mmorpg
        SHOOTER -> R.string.shooter
        STRATEGY -> R.string.strategy
        MOBA -> R.string.moba
    }

    val codeFilters get() = when(this){
        MMORPG -> "mmorpg"
        SHOOTER -> "shooter"
        STRATEGY -> "strategy"
        MOBA -> "moba"
    }
}