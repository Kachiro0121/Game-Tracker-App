package com.kachiro.core_impl.shared

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides

@Module
object SharedModel {

    private const val PREFS_NAME = "GAME_TRACKER"

    @JvmStatic
    @Provides
    fun provideShared(context: Context): SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

}