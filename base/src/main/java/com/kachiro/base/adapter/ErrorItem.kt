package com.kachiro.base.adapter

import android.view.View
import com.kachiro.uikit.R
import com.kachiro.uikit.databinding.ErrorScreenBinding
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

class ErrorItem : AbstractItem<ErrorItem.ViewHolder>() {

    override val type: Int
        get() = R.id.error_item

    override val layoutRes: Int
        get() = R.layout.error_screen

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(view: View) : FastAdapter.ViewHolder<ErrorItem>(view) {

        private val binding = ErrorScreenBinding.bind(itemView)

        override fun bindView(item: ErrorItem, payloads: List<Any>) {

        }

        override fun unbindView(item: ErrorItem) {

        }
    }
}