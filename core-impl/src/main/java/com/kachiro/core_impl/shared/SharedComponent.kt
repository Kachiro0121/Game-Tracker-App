package com.kachiro.core_impl.shared

import android.content.Context
import com.kachiro.core_api.di.SharedPreferenceProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SharedModel::class])
interface SharedComponent: SharedPreferenceProvider{

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): SharedComponent
    }

}