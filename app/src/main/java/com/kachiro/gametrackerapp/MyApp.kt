package com.kachiro.gametrackerapp

import android.app.Application
import com.kachiro.core_api.di.AppWithApplicationComponent
import com.kachiro.core_api.di.ApplicationComponentProvider
import com.kachiro.gametrackerapp.di.ApplicationComponent

class MyApp: Application(), AppWithApplicationComponent {

    private var appComponent: ApplicationComponent? = null

    override fun getApplicationComponentProvider(): ApplicationComponentProvider = appComponent
        ?: ApplicationComponent
            .init(application = this)
            .also {
                appComponent = it
            }

}