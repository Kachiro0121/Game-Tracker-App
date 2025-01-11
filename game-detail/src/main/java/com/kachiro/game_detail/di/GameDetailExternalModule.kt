package com.kachiro.game_detail.di

import com.kachiro.game_detail.GameDetailMediatorImpl
import com.kachiro.game_detail_api.GameDetailMediator
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
interface GameDetailExternalModule {

    @Binds
    @IntoMap
    @ClassKey(GameDetailMediator::class)
    fun bindMediator(mediator: GameDetailMediatorImpl): Any
}