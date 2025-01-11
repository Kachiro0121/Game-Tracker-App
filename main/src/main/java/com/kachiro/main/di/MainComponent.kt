package com.kachiro.main.di

import com.kachiro.core_api.di.ApplicationComponentProvider
import com.kachiro.main.MainActivity
import dagger.Component

@Component(
    modules = [MainModule::class],
    dependencies = [ApplicationComponentProvider::class]
)
interface MainComponent {

    companion object {

        fun create(appComponentProvider: ApplicationComponentProvider): MainComponent {
            return DaggerMainComponent.builder()
                .applicationComponentProvider(appComponentProvider)
                .build()
        }
    }

    fun inject(mainActivity: MainActivity)
}