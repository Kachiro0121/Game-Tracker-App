package com.kachiro.main.viewmodel

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.kachiro.home_api.HomeMediator

class MainViewModel constructor(
    private val homeMediator: HomeMediator
) : ViewModel() {

    fun startScreen(@IdRes container: Int, fragmentManager: FragmentManager) {
        homeMediator.startHomeScreen(container, fragmentManager)
    }
}