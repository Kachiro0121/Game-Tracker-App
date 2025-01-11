package com.kachiro.core_impl.di

import com.kachiro.core_api.network.NetworkProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent: NetworkProvider