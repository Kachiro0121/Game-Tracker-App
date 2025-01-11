package com.kachiro.game.di

import com.kachiro.core_api.di.ApplicationComponentProvider
import com.kachiro.game.GameListFragment
import com.kachiro.game_api.GameListMediator
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton

@Component(
    modules = [GameListModule::class, ManagerListModule::class],
    dependencies = [ApplicationComponentProvider::class]
)
interface GameListComponent {

    companion object {

        fun create(applicationComponentProvider: ApplicationComponentProvider): GameListComponent {
            return DaggerGameListComponent
                .builder()
                .applicationComponentProvider(applicationComponentProvider)
                .build()
        }

    }

    fun inject(gameListFragment: GameListFragment)

}