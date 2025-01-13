package com.kachiro.game_catalog.adapter

import android.view.View
import com.bumptech.glide.Glide
import com.kachiro.core_api.dto.Game
import com.kachiro.game_catalog.R
import com.kachiro.game_catalog.databinding.CardGameItemBinding
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.ModelAbstractItem

class GameItem(model: Game) : ModelAbstractItem<Game, GameItem.ViewHolder>(model) {

    override val type: Int
        get() = R.id.game_item

    override val layoutRes: Int
        get() = R.layout.card_game_item

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(view: View) : FastAdapter.ViewHolder<GameItem>(view) {

        private val binding = CardGameItemBinding.bind(itemView)

        override fun bindView(item: GameItem, payloads: List<Any>) {
            binding.title.text = item.model.title
            binding.description.text = item.model.short_description
            binding.genre.text = item.model.genre
            binding.releaseDate.text = item.model.release_date
            Glide.with(itemView)
                .load(item.model.thumbnail)
                .into(binding.backgroundImage)
        }

        override fun unbindView(item: GameItem) {
            binding.title.text = null
            binding.description.text = null
            binding.backgroundImage.setImageURI(null)
        }
    }
}