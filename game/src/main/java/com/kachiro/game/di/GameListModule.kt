package com.kachiro.game.di

import androidx.lifecycle.ViewModelProvider
import com.kachiro.game.repository.GameApiService
import com.kachiro.game.repository.GameRepository
import com.kachiro.game.repository.GameRepositoryImpl
import com.kachiro.game.viewModels.GameViewModelFactory
import com.kachiro.game_detail_api.GameDetailMediator
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Provider

@Module
interface GameListModule {

    @Binds
    fun bindViewModelFactory(factory: GameViewModelFactory): ViewModelProvider.Factory

    @Binds
    fun bindRepository(repository: GameRepositoryImpl): GameRepository

    companion object{

        @Provides
        fun provideGameApiService(retrofit: Retrofit): GameApiService = retrofit.create(GameApiService::class.java)

        @Provides
        fun provideMediatorGameDetail(map: Map<Class<*>, @JvmSuppressWildcards Provider<Any>>): GameDetailMediator {
            return map[GameDetailMediator::class.java]!!.get() as GameDetailMediator
        }

    }

}