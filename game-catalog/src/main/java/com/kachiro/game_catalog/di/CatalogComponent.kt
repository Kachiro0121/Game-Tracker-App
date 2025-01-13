package com.kachiro.game_catalog.di

import com.kachiro.core_api.di.ApplicationComponentProvider
import com.kachiro.game_catalog.CatalogFragment
import dagger.Component

@Component(
    modules = [CatalogModule::class, ManagerListModule::class],
    dependencies = [ApplicationComponentProvider::class]
)
interface CatalogComponent {

    companion object {

        fun create(applicationComponentProvider: ApplicationComponentProvider): CatalogComponent {
            return DaggerCatalogComponent
                .builder()
                .applicationComponentProvider(applicationComponentProvider)
                .build()
        }

    }

    fun inject(fragment: CatalogFragment)

}