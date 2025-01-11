package com.kachiro.game_detail.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kachiro.game_detail.repository.DetailRepository
import javax.inject.Inject

class DetailViewModelFactory @Inject constructor(
    private val repository: DetailRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailViewModel(repository) as T
    }
}