package com.kachiro.imageviewer_api

import com.kachiro.imageviewer_api.dto.ImagesModel

interface ImageViewerMediator {

    fun openImageViewer(imagesModel: ImagesModel)

}