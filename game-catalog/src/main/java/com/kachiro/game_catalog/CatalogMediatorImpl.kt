package com.kachiro.game_catalog

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.kachiro.base.navigate.AnimatedFragmentScreen
import com.kachiro.game_catalog_api.CatalogMediator
import com.kachiro.uikit.R
import javax.inject.Inject

class CatalogMediatorImpl @Inject constructor(
    private val router: Router
) : CatalogMediator {

    override fun openScreenCatalog() {
        val screen = AnimatedFragmentScreen(
            fragment = CatalogFragment.newInstance() ,
            enterAnimation = R.anim.slide_in_right,
            exitAnimation = R.anim.slide_out_left,
            popEnterAnimation = R.anim.slide_in_left,
            popExitAnimation = R.anim.slide_out_right
        )
        router.replaceScreen(screen)
    }

}