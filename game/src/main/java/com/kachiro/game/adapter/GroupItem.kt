package com.kachiro.game.adapter

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.google.android.material.divider.MaterialDividerItemDecoration
import com.kachiro.base.dp
import com.kachiro.game.R
import com.kachiro.game.databinding.GroupItemBinding
import com.kachiro.game.dto.TypeItem
import com.kachiro.game_api.dto.GameCategory
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.adapters.FastItemAdapter
import com.mikepenz.fastadapter.items.ModelAbstractItem
import com.mikepenz.fastadapter.listeners.ClickEventHook

class GroupItem(model: GameCategory, private val clickEventHook: ClickEventHook<GenericItem>) : ModelAbstractItem<GameCategory, GroupItem.ViewHolder>(model) {

    override val type: Int
        get() = TypeItem.TYPE_GROUP.ordinal

    override val layoutRes: Int
        get() = R.layout.group_item

    override fun getViewHolder(v: View): ViewHolder = ViewHolder(v)

    inner class ViewHolder(view: View) : FastAdapter.ViewHolder<GroupItem>(view) {

        private val binding = GroupItemBinding.bind(itemView)
        private val gameAdapter = FastItemAdapter<GenericItem>().apply {
            addEventHook(clickEventHook)
        }
        private val itemDecoration by lazy {
            MaterialDividerItemDecoration(view.context, HORIZONTAL).apply {
                dividerThickness = 16.dp
                dividerColor = Color.TRANSPARENT
            }
        }

        init {
            binding.listItem.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
            binding.listItem.adapter = gameAdapter
            binding.listItem.addItemDecoration(itemDecoration)
        }

        override fun bindView(item: GroupItem, payloads: List<Any>) {
            binding.title.text = item.model.title
            gameAdapter.setNewList(item.model.listGame.map { GameCardItem(it) })
        }

        override fun unbindView(item: GroupItem) {
            binding.title.text = null
        }
    }
}