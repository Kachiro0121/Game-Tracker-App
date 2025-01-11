package com.kachiro.core_api.di

import android.content.Context

interface AppProvider {

    fun provideContext(): Context

}