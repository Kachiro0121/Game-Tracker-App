package com.kachiro.home.help

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.kachiro.base.navigate.AnimatedFragmentScreen

class AnimatedFragmentNavigator(
    activity: FragmentActivity,
    containerId: Int,
    fragmentManager: FragmentManager,
) : AppNavigator(activity, containerId, fragmentManager) {

    override fun setupFragmentTransaction(
        screen: FragmentScreen,
        fragmentTransaction: FragmentTransaction,
        currentFragment: Fragment?,
        nextFragment: Fragment
    ) {

        super.setupFragmentTransaction(screen, fragmentTransaction, currentFragment, nextFragment)

        if (screen is AnimatedFragmentScreen) {
            fragmentTransaction.setCustomAnimations(
                screen.enterAnimation,
                screen.exitAnimation,
                screen.popEnterAnimation,
                screen.popExitAnimation
            )
        }
    }
}