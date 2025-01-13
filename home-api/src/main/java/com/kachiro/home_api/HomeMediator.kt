package com.kachiro.home_api

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager

interface HomeMediator {

    fun startHomeScreen(@IdRes container: Int, fragmentManager: FragmentManager)

}