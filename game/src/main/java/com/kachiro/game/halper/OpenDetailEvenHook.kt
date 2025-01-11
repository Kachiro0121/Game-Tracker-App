package com.kachiro.game.halper

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.kachiro.game.adapter.GameCardItem
import com.kachiro.game.adapter.GameCardRecommendItem
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.listeners.ClickEventHook
import javax.inject.Inject

class OpenDetailEvenHook @Inject constructor(private val actionHandler: ActionHandler) : ClickEventHook<GenericItem>() {

    override fun onBind(viewHolder: RecyclerView.ViewHolder): View? {
        return viewHolder.itemView
    }

    override fun onClick(v: View, position: Int, fastAdapter: FastAdapter<GenericItem>, item: GenericItem) {
        when(item){
            is GameCardItem -> actionHandler.openDetail(item.model.id)
            is GameCardRecommendItem -> actionHandler.openDetail(item.model.id)
        }

    }
}