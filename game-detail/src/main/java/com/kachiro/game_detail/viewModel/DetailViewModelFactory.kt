package com.kachiro.game_detail.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kachiro.game_detail.repository.DetailRepository
import com.kachiro.imageviewer_api.ImageViewerMediator
import javax.inject.Inject

class DetailViewModelFactory @Inject constructor(
    private val repository: DetailRepository,
    private val imageViewerMediator: ImageViewerMediator
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailViewModel(repository, imageViewerMediator) as T
    }
}