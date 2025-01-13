package com.kachiro.core_factory

import android.content.Context
import com.kachiro.core_api.di.NavigateProvide
import com.kachiro.core_api.di.NetworkProvider
import com.kachiro.core_api.di.SharedPreferenceProvider
import com.kachiro.core_impl.navigation.DaggerNavigationComponent
import com.kachiro.core_impl.network.DaggerNetworkComponent
import com.kachiro.core_impl.shared.DaggerSharedComponent

object CoreProviderFactory {

    fun createNetworkProvider(): NetworkProvider {
        return DaggerNetworkComponent.create()
    }

    fun createNavigateProvider(): NavigateProvide {
        return DaggerNavigationComponent.create()
    }

    fun createSharedPreference(context: Context): SharedPreferenceProvider{
        return DaggerSharedComponent.factory().create(context)
    }

}