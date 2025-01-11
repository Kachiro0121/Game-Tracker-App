package com.kachiro.game.adapter

import android.view.View
import com.bumptech.glide.Glide
import com.kachiro.game.R
import com.kachiro.game.databinding.CardGameHalfBinding
import com.kachiro.game_api.dto.Game
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.ModelAbstractItem

class GameCardItem(model: Game) : ModelAbstractItem<Game, GameCardItem.ViewHolder>(model) {

    override val type: Int
        get() = R.id.game_card_half

    override val layoutRes: Int
        get() = R.layout.card_game_half

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(view: View) : FastAdapter.ViewHolder<GameCardItem>(view) {

        private val binding = CardGameHalfBinding.bind(itemView)

        override fun bindView(item: GameCardItem, payloads: List<Any>) {
            binding.title.text = item.model.title
            binding.description.text = item.model.short_description
            Glide.with(itemView)
                .load(item.model.thumbnail)
                .into(binding.backgroundImage)
        }

        override fun unbindView(item: GameCardItem) {
            binding.title.text = null
            binding.description.text = null
            binding.backgroundImage.setImageURI(null)
        }
    }
}