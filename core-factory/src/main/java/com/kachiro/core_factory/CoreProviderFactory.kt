package com.kachiro.core_factory

import com.kachiro.core_api.di.NavigateProvide
import com.kachiro.core_api.network.NetworkProvider
import com.kachiro.core_impl.di.DaggerNavigationComponent
import com.kachiro.core_impl.di.DaggerNetworkComponent

object CoreProviderFactory {

    fun createNetworkProvider(): NetworkProvider {
        return DaggerNetworkComponent.create()
    }

    fun createNavigateProvider(): NavigateProvide {
        return DaggerNavigationComponent.create()
    }

}