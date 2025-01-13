package com.kachiro.home.viewmodel

import androidx.lifecycle.ViewModel
import com.kachiro.game_api.GameListMediator
import com.kachiro.game_catalog_api.CatalogMediator

class HomeViewModel constructor(
    private val gameListMediator: GameListMediator,
    private val catalogMediator: CatalogMediator
) : ViewModel() {

    fun gameScreen() {
        gameListMediator.openScreenGameList()
    }

    fun catalogScreen(){
        catalogMediator.openScreenCatalog()
    }
}