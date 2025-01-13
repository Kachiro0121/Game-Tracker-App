package com.kachiro.game_catalog.di

import com.kachiro.game_catalog.CatalogMediatorImpl
import com.kachiro.game_catalog_api.CatalogMediator
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
interface CatalogExternalModule {
    @Binds
    @IntoMap
    @ClassKey(CatalogMediator::class)
    fun bindMediator(mediator: CatalogMediatorImpl): Any
}