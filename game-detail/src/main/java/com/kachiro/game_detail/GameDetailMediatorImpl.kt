package com.kachiro.game_detail

import com.github.terrakok.cicerone.Router
import com.kachiro.base.navigate.AnimatedFragmentScreen
import com.kachiro.game_detail_api.GameDetailMediator
import com.kachiro.uikit.R
import javax.inject.Inject

class GameDetailMediatorImpl @Inject constructor(
    private val router: Router
) : GameDetailMediator {

    override fun openScreenDetailGame(id: Int) {

        val screen = AnimatedFragmentScreen(
            fragment = GameDetailFragment.newInstance(id) ,
            enterAnimation = R.anim.slide_in_right,
            exitAnimation = R.anim.slide_out_left,
            popEnterAnimation = R.anim.slide_in_left,
            popExitAnimation = R.anim.slide_out_right
        )

        router.navigateTo(screen)
    }

}