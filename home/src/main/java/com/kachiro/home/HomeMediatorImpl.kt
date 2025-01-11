package com.kachiro.home

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.kachiro.home_api.HomeMediator
import javax.inject.Inject

class HomeMediatorImpl @Inject constructor(
    private val router: Router
) : HomeMediator {

    val home get() = FragmentScreen { HomeFragment.newInstance() }

    override fun startHomeScreen() {
        router.newRootScreen(home)
    }

}