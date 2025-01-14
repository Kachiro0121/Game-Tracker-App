package com.kachiro.base.navigate

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AnimatedFragmentScreen(
    val fragment: Fragment,
    val enterAnimation: Int,
    val exitAnimation: Int,
    val popEnterAnimation: Int,
    val popExitAnimation: Int
) : FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment = fragment
}