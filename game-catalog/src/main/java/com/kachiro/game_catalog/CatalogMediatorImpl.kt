package com.kachiro.game_catalog

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.kachiro.game_catalog_api.CatalogMediator
import javax.inject.Inject

class CatalogMediatorImpl @Inject constructor(
    private val router: Router
) : CatalogMediator {

    private val catalogScreen get() = FragmentScreen{ CatalogFragment.newInstance() }

    override fun openScreenCatalog() {
        router.replaceScreen(catalogScreen)
    }

}