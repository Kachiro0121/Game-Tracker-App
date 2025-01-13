package com.kachiro.game_catalog.di

import androidx.lifecycle.ViewModelProvider
import com.kachiro.game_catalog.repository.CatalogApiService
import com.kachiro.game_catalog.repository.Repository
import com.kachiro.game_catalog.repository.RepositoryImpl
import com.kachiro.game_catalog.viewModels.CatalogViewModelFactory
import com.kachiro.game_detail_api.GameDetailMediator
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Provider

@Module
interface CatalogModule {

    @Binds
    fun bindViewModelFactory(factory: CatalogViewModelFactory): ViewModelProvider.Factory

    @Binds
    fun bindRepository(repository: RepositoryImpl): Repository

    companion object{

        @Provides
        fun provideApiService(retrofit: Retrofit): CatalogApiService = retrofit.create(CatalogApiService::class.java)

        @Provides
        fun provideMediatorGameDetail(map: Map<Class<*>, @JvmSuppressWildcards Provider<Any>>): GameDetailMediator {
            return map[GameDetailMediator::class.java]!!.get() as GameDetailMediator
        }

    }

}