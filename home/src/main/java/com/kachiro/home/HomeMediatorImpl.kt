package com.kachiro.home

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.kachiro.home_api.HomeMediator
import javax.inject.Inject

class HomeMediatorImpl @Inject constructor() : HomeMediator {

    override fun startHomeScreen(@IdRes container: Int, fragmentManager: FragmentManager) {
        fragmentManager.beginTransaction().replace(container, HomeFragment.newInstance()).commitNow()
    }

}