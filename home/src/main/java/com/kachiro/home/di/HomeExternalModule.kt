package com.kachiro.home.di

import com.kachiro.home.HomeMediatorImpl
import com.kachiro.home_api.HomeMediator
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
interface HomeExternalModule {
    @Binds
    @IntoMap
    @ClassKey(HomeMediator::class)
    fun bindMediator(mediator: HomeMediatorImpl): Any
}