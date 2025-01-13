package com.kachiro.game_catalog.di

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import dagger.Module
import dagger.Provides

@Module
interface ManagerListModule {

    companion object{

        @Provides
        fun provideFastAdapter(): FastItemAdapter<GenericItem> = FastItemAdapter()

    }

}