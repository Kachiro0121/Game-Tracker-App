package com.kachiro.game.adapter

import android.view.View
import com.bumptech.glide.Glide
import com.kachiro.game.R
import com.kachiro.game.databinding.CardGameBinding
import com.kachiro.core_api.dto.Game
import com.kachiro.game.dto.TypeItem
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.ModelAbstractItem

class GameCardRecommendItem(model: Game) : ModelAbstractItem<Game, GameCardRecommendItem.ViewHolder>(model) {

    override val type: Int
        get() = TypeItem.TYPE_RECOMMEND.ordinal

    override val layoutRes: Int
        get() = R.layout.card_game

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(view: View) : FastAdapter.ViewHolder<GameCardRecommendItem>(view) {

        val binding = CardGameBinding.bind(itemView)

        override fun bindView(item: GameCardRecommendItem, payloads: List<Any>) {
            binding.title.text = item.model.title
            binding.description.text = item.model.short_description
            Glide.with(itemView)
                .load(item.model.thumbnail)
                .into(binding.backgroundImage)
        }

        override fun unbindView(item: GameCardRecommendItem) {
            binding.title.text = null
            binding.description.text = null
            binding.backgroundImage.setImageURI(null)
        }
    }
}