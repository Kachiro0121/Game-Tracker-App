package com.kachiro.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kachiro.game_api.GameListMediator
import com.kachiro.game_catalog_api.CatalogMediator
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(
    private val gameListMediator: GameListMediator,
    private val catalogMediator: CatalogMediator
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(gameListMediator, catalogMediator) as T
    }
}