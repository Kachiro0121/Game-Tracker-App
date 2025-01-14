package com.kachiro.game_detail.di

import androidx.lifecycle.ViewModelProvider
import com.kachiro.game_detail.repository.DetailRepository
import com.kachiro.game_detail.repository.DetailRepositoryImpl
import com.kachiro.game_detail.repository.GameDetailApiService
import com.kachiro.game_detail.viewModel.DetailViewModelFactory
import com.kachiro.imageviewer_api.ImageViewerMediator
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Provider

@Module
interface GameDetailModule {

    @Binds
    fun bindViewModelFactory(factory: DetailViewModelFactory): ViewModelProvider.Factory

    @Binds
    fun bindRepository(repository: DetailRepositoryImpl): DetailRepository

    companion object{

        @Provides
        fun provideApiService(retrofit: Retrofit): GameDetailApiService = retrofit.create(GameDetailApiService::class.java)

        @Provides
        fun provideMediatorImageViewer(map: Map<Class<*>, @JvmSuppressWildcards Provider<Any>>): ImageViewerMediator {
            return map[ImageViewerMediator::class.java]!!.get() as ImageViewerMediator
        }

    }

}