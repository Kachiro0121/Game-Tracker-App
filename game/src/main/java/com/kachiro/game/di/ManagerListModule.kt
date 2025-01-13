package com.kachiro.game.di

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.kachiro.game.halper.ActionHandler
import com.kachiro.game.halper.ActionHandlerImpl
import com.kachiro.game.halper.OpenDetailEvenHook
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import com.mikepenz.fastadapter.listeners.ClickEventHook
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@Module
interface ManagerListModule {

    @Binds
    fun bindOpenDetailHook(actionHandlerImpl: ActionHandlerImpl): ActionHandler

    companion object{

        @Provides
        fun provideFastAdapter(): FastItemAdapter<GenericItem> = FastItemAdapter()

        @Provides
        fun provideClickEventHook(actionHandler: ActionHandler): ClickEventHook<GenericItem> = OpenDetailEvenHook(actionHandler)

    }

}

