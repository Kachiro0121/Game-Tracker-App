package com.kachiro.imageviewer.adapter

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.kachiro.imageviewer.R
import com.kachiro.imageviewer.databinding.ImageItemBinding
import com.kachiro.imageviewer_api.dto.ImageModel
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

class ImageItem(val image: ImageModel) : AbstractItem<ImageItem.ViewHolder>() {

    override val type: Int
        get() = R.id.image_item_id

    override val layoutRes: Int
        get() = R.layout.image_item

    override fun getViewHolder(v: View): ViewHolder = ViewHolder(v)

    class ViewHolder(view: View) : FastAdapter.ViewHolder<ImageItem>(view) {

        private val binding: ImageItemBinding = ImageItemBinding.bind(itemView)

        override fun bindView(item: ImageItem, payloads: List<Any>) {
            Glide.with(itemView.context)
                .load(item.image.url)
                .into(binding.photoView as ImageView)
        }

        override fun unbindView(item: ImageItem) {
            binding.photoView.setImageDrawable(null)
        }
    }
}