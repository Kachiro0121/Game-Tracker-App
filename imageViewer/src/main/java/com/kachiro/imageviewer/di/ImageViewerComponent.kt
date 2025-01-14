package com.kachiro.imageviewer.di

import com.kachiro.core_api.di.ApplicationComponentProvider
import com.kachiro.imageviewer.ImageViewerFragment
import dagger.Component

@Component(
    modules = [ImageViewerModule::class],
    dependencies = [ApplicationComponentProvider::class]
)
interface ImageViewerComponent {

    companion object{
        fun create(appComponent: ApplicationComponentProvider): ImageViewerComponent {
            return DaggerImageViewerComponent.builder()
                .applicationComponentProvider(appComponent)
                .build()
        }

    }

    fun inject(fragment: ImageViewerFragment)

}