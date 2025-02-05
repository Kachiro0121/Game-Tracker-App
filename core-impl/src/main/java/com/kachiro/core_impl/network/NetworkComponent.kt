package com.kachiro.core_impl.network

import com.kachiro.core_api.di.NetworkProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent: NetworkProvider