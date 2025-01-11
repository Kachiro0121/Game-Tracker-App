package com.kachiro.core_api.di

import javax.inject.Provider

interface MediatorProvider {

    fun mediatorsMap(): Map<Class<*>, @JvmSuppressWildcards Provider<Any>>

}