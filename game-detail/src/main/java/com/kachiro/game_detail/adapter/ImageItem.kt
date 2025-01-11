package com.kachiro.game_detail.adapter

import android.view.View
import com.bumptech.glide.Glide
import com.kachiro.game_detail.R
import com.kachiro.game_detail.databinding.GalleryItemBinding
import com.kachiro.game_detail.databinding.InfoItemBinding
import com.kachiro.game_detail.dto.Info
import com.kachiro.game_detail.dto.Screenshots
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.ModelAbstractItem

class ImageItem(model: Screenshots) : ModelAbstractItem<Screenshots, ImageItem.ViewHolder>(model) {

    override val type: Int
        get() = R.id.gallery_item

    override val layoutRes: Int
        get() = R.layout.gallery_item

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(view: View) : FastAdapter.ViewHolder<ImageItem>(view) {

        private val binding = GalleryItemBinding.bind(itemView)

        override fun bindView(item: ImageItem, payloads: List<Any>) {
            val model = item.model
            Glide.with(itemView)
                .load(model.image)
                .into(binding.image)
        }

        override fun unbindView(item: ImageItem) {

        }
    }
}