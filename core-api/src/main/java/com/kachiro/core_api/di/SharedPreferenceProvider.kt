package com.kachiro.core_api.di

import android.content.SharedPreferences

interface SharedPreferenceProvider {

    fun provideSharedPreference(): SharedPreferences

}