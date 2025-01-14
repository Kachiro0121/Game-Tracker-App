package com.kachiro.imageviewer.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kachiro.imageviewer.adapter.ImageItem
import com.kachiro.imageviewer_api.dto.ImagesModel

class ImageViewerViewModel: ViewModel() {

    private val _imageData = MutableLiveData<List<ImageItem>>()
    val imageData: LiveData<List<ImageItem>> = _imageData

    private val _currentIndex = MutableLiveData<Int>()
    val currentIndex: LiveData<Int> = _currentIndex

    fun setImageData(modelImage: ImagesModel) {
        _imageData.value = modelImage.images.map { ImageItem(it).apply { isSelected = it.id == modelImage.openId } }
    }

    fun setCurrentIndex(position: Int) {
        _currentIndex.value = position
    }

}
