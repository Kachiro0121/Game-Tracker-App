package com.kachiro.game_detail.di

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier

@Module
interface ManagerInfoModule {

    companion object{

        @Provides
        @InfoList
        fun provideFastAdapter(): FastItemAdapter<GenericItem> = FastItemAdapter()

    }

}

@Qualifier
annotation class InfoList