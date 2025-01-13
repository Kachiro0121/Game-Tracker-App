package com.kachiro.game

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.kachiro.game_api.GameListMediator
import javax.inject.Inject

class GameListMediatorImpl @Inject constructor(
    private val router: Router
) : GameListMediator {

    private val gameHomeList get() =  FragmentScreen{ GameListFragment.newInstance() }

    override fun openScreenGameList() {
        router.navigateTo(gameHomeList)
    }

}