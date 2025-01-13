package com.kachiro.gametrackerapp.di

import android.app.Application
import com.kachiro.core_api.di.AppProvider
import com.kachiro.core_api.di.ApplicationComponentProvider
import com.kachiro.core_api.di.NavigateProvide
import com.kachiro.core_api.network.NetworkProvider
import com.kachiro.core_factory.CoreProviderFactory
import com.kachiro.game.di.GameListExternalModule
import com.kachiro.game_catalog.di.CatalogExternalModule
import com.kachiro.game_detail.di.GameDetailExternalModule
import com.kachiro.home.di.HomeExternalModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [AppProvider::class, NetworkProvider::class, NavigateProvide::class],
    modules = [HomeExternalModule::class, GameListExternalModule::class, GameDetailExternalModule::class, CatalogExternalModule::class]
)
interface ApplicationComponent : ApplicationComponentProvider {

    companion object{

        fun init(application: Application): ApplicationComponent = DaggerApplicationComponent.builder()
            .navigateProvide(CoreProviderFactory.createNavigateProvider())
            .appProvider(ApplicationContextComponent.create(application))
            .networkProvider(CoreProviderFactory.createNetworkProvider())
            .build()

    }

}