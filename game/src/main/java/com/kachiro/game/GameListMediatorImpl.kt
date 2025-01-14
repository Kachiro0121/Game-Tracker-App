package com.kachiro.game

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.kachiro.base.navigate.AnimatedFragmentScreen
import com.kachiro.game_api.GameListMediator
import com.kachiro.uikit.R
import javax.inject.Inject

class GameListMediatorImpl @Inject constructor(
    private val router: Router
) : GameListMediator {

    override fun openScreenGameList() {
        val screen = AnimatedFragmentScreen(
            fragment = GameListFragment.newInstance() ,
            enterAnimation = R.anim.slide_in_left,
            exitAnimation = R.anim.slide_out_right,
            popEnterAnimation = R.anim.slide_in_right,
            popExitAnimation = R.anim.slide_out_left
        )
        router.newRootScreen(screen)
    }

}