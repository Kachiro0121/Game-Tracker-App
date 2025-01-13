package com.kachiro.game_catalog.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kachiro.game_catalog.repository.Repository
import com.kachiro.game_detail_api.GameDetailMediator
import javax.inject.Inject

class CatalogViewModelFactory @Inject constructor(
    private val repository: Repository,
    private val gameDetailMediator: GameDetailMediator
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CatalogViewModel(repository, gameDetailMediator) as T
    }
}