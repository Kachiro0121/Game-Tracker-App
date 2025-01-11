package com.kachiro.home.di

import com.kachiro.core_api.di.ApplicationComponentProvider
import com.kachiro.home.HomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [HomeModule::class],
    dependencies = [ApplicationComponentProvider::class]
)
interface HomeComponent {

    companion object {

        fun create(applicationComponentProvider: ApplicationComponentProvider): HomeComponent {
            return DaggerHomeComponent
                .builder()
                .applicationComponentProvider(applicationComponentProvider)
                .build()
        }
    }

    fun inject(homeFragment: HomeFragment)
}