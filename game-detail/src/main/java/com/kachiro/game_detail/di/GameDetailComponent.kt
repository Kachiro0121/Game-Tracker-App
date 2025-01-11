package com.kachiro.game_detail.di

import com.kachiro.core_api.di.ApplicationComponentProvider
import com.kachiro.game_detail.GameDetailFragment
import dagger.Component


@Component(
    modules = [GameDetailModule::class, ManagerGalleryModule::class, ManagerInfoModule::class],
    dependencies = [ApplicationComponentProvider::class]
)
interface GameDetailComponent {

    companion object{
        fun create(applicationComponentProvider: ApplicationComponentProvider): GameDetailComponent{
            return DaggerGameDetailComponent.builder()
                .applicationComponentProvider(applicationComponentProvider)
                .build()
        }
    }

    fun inject(gameDetailFragment: GameDetailFragment)

}