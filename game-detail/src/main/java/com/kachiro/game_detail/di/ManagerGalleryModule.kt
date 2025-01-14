package com.kachiro.game_detail.di

import android.content.Context
import android.graphics.Color
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.google.android.material.divider.MaterialDividerItemDecoration
import com.kachiro.base.dp
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier

@Module
interface ManagerGalleryModule {

    companion object{

        @Provides
        @GalleryList
        fun provideFastAdapter(): FastItemAdapter<GenericItem> = FastItemAdapter()

    }

}

@Qualifier
annotation class GalleryList