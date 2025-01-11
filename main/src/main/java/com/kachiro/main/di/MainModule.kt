package com.kachiro.main.di

import androidx.lifecycle.ViewModelProvider
import com.kachiro.home_api.HomeMediator
import com.kachiro.main.viewmodel.MainViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
interface MainModule {

    @Binds
    fun bindsHomeViewModelFactory(mainViewModelFactory: MainViewModelFactory): ViewModelProvider.Factory

    companion object{
      @Provides
      fun provideHomeMediator(map: Map<Class<*>, @JvmSuppressWildcards Provider<Any>>): HomeMediator {
          return map[HomeMediator::class.java]!!.get() as HomeMediator
      }
  }

}