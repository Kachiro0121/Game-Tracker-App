package com.kachiro.imageviewer

import com.github.terrakok.cicerone.Router
import com.kachiro.base.navigate.AnimatedFragmentScreen
import com.kachiro.imageviewer_api.ImageViewerMediator
import com.kachiro.imageviewer_api.dto.ImagesModel
import com.kachiro.uikit.R
import javax.inject.Inject

class ImageViewerMediatorImpl @Inject constructor(
    private val router: Router
) : ImageViewerMediator {

    override fun openImageViewer(imagesModel: ImagesModel) {
        val screen = AnimatedFragmentScreen(
            fragment = ImageViewerFragment.newInstance(imagesModel) ,
            enterAnimation = R.anim.slide_in_right,
            exitAnimation = R.anim.slide_out_left,
            popEnterAnimation = R.anim.slide_in_left,
            popExitAnimation = R.anim.slide_out_right
        )

        router.navigateTo(screen)
    }

}