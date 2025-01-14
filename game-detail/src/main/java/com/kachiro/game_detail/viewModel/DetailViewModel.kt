package com.kachiro.game_detail.viewModel

import android.provider.MediaStore.Images
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kachiro.game_detail.dto.GameDetail
import com.kachiro.game_detail.repository.DetailRepository
import com.kachiro.imageviewer_api.ImageViewerMediator
import com.kachiro.imageviewer_api.dto.ImageModel
import com.kachiro.imageviewer_api.dto.ImagesModel
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: DetailRepository,
    private val imageViewerMediator: ImageViewerMediator
): ViewModel() {

    companion object{
        private const val TAG = "DetailViewModel"
    }

    private val _detail: MutableLiveData<GameDetail> = MutableLiveData()
    val detail: LiveData<GameDetail> = _detail

    fun setGame(id: Int){
        viewModelScope.launch {
            try {
                _detail.value = repository.gameDetail(id)
            } catch (e: Exception) {
                Log.d(TAG, "setGame: ${e.message}")
            }
        }
    }

    fun openImageView(id: Int?) {
        val listImages = getImages()
        val model = ImagesModel(
            openId = id ?: return,
            images = listImages ?: return
        )
        imageViewerMediator.openImageViewer(model)
    }

    private fun getImages(): List<ImageModel>? {
        return _detail.value?.screenshots?.map {
            val id = it.id ?: return@map null
            val url = it.image ?: return@map null
            ImageModel(id, url)
        }?.filterNotNull()
    }

}