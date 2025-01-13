package com.kachiro.home.di

import androidx.lifecycle.ViewModelProvider
import com.kachiro.game_api.GameListMediator
import com.kachiro.game_catalog_api.CatalogMediator
import com.kachiro.home.viewmodel.HomeViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
interface HomeModule {

    @Binds
    fun bindViewModelFactory(factory: HomeViewModelFactory): ViewModelProvider.Factory

    companion object{

        @Provides
        fun provideMediatorGameList(map: Map<Class<*>, @JvmSuppressWildcards Provider<Any>>): GameListMediator {
            return map[GameListMediator::class.java]!!.get() as GameListMediator
        }

        @Provides
        fun provideMediatorCatalog(map: Map<Class<*>, @JvmSuppressWildcards Provider<Any>>): CatalogMediator {
            return map[CatalogMediator::class.java]!!.get() as CatalogMediator
        }

    }

}