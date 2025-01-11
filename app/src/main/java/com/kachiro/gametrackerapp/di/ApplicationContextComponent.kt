package com.kachiro.gametrackerapp.di

import android.app.Application
import android.content.Context
import com.kachiro.core_api.di.AppProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface ApplicationContextComponent: AppProvider {

    companion object{

        private var appComponent: AppProvider? = null

        fun create(application: Application): AppProvider = appComponent ?: DaggerApplicationContextComponent
            .builder()
            .application(application)
            .build().also {
                appComponent = it
            }
    }

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(context: Context): Builder

        fun build(): ApplicationContextComponent

    }

}

