package com.kachiro.game_detail.adapter

import android.view.View
import com.kachiro.game_detail.R
import com.kachiro.game_detail.databinding.InfoItemBinding
import com.kachiro.game_detail.dto.Info
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.ModelAbstractItem

class InfoItem(model: Info) : ModelAbstractItem<Info, InfoItem.ViewHolder>(model) {

    override val type: Int
        get() = R.id.info_item

    override val layoutRes: Int
        get() = R.layout.info_item

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(view: View) : FastAdapter.ViewHolder<InfoItem>(view) {

        private val binding = InfoItemBinding.bind(itemView)

        override fun bindView(item: InfoItem, payloads: List<Any>) {
            val info = item.model
            binding.title.text = String.format("%s:", info.title )
            binding.text.text = info.value
        }

        override fun unbindView(item: InfoItem) {
            binding.title.text = null
            binding.text.text = null
        }
    }
}