package com.kachiro.core_factory

import com.kachiro.core_api.di.NavigateProvide
import com.kachiro.core_api.di.NetworkProvider
import com.kachiro.core_impl.navigation.DaggerNavigationComponent
import com.kachiro.core_impl.network.DaggerNetworkComponent

object CoreProviderFactory {

    fun createNetworkProvider(): NetworkProvider {
        return DaggerNetworkComponent.create()
    }

    fun createNavigateProvider(): NavigateProvide {
        return DaggerNavigationComponent.create()
    }

}