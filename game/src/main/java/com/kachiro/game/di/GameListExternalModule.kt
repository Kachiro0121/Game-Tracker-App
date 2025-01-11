package com.kachiro.game.di

import com.kachiro.game.GameListMediatorImpl
import com.kachiro.game_api.GameListMediator
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
interface GameListExternalModule {

    @Binds
    @IntoMap
    @ClassKey(GameListMediator::class)
    fun bindMediator(mediator: GameListMediatorImpl): Any
}