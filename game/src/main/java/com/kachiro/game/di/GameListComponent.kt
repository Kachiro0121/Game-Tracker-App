package com.kachiro.game.di

import com.kachiro.core_api.di.ApplicationComponentProvider
import com.kachiro.game.GameListFragment
import dagger.Component

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