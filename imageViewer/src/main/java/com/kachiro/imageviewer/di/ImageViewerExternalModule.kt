package com.kachiro.imageviewer.di

import com.kachiro.imageviewer_api.ImageViewerMediator
import com.kachiro.imageviewer.ImageViewerMediatorImpl
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
interface ImageViewerExternalModule {
    @Binds
    @IntoMap
    @ClassKey(ImageViewerMediator::class)
    fun bindMediator(mediator: ImageViewerMediatorImpl): Any
}