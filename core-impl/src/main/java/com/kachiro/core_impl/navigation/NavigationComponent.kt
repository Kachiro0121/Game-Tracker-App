package com.kachiro.core_impl.navigation

import com.kachiro.core_api.di.NavigateProvide
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NavigationModule::class])
interface NavigationComponent: NavigateProvide