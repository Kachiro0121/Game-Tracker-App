package com.kachiro.core_api.di

import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router


interface NavigateProvide {

    fun provideRouter(): Router

    fun provideNavigatorHolder(): NavigatorHolder
}