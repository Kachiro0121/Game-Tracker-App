package com.kachiro.game

import android.view.View
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.kachiro.core_api.dto.Game
import com.kachiro.game.adapter.GameCardItem
import com.kachiro.game.adapter.GameCardRecommendItem
import com.kachiro.game.halper.ActionHandler
import com.kachiro.game.halper.OpenDetailEvenHook
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.GenericItem
import io.mockk.Runs
import io.mockk.every
import io.mockk.just

class OpenDetailEvenHookTest {

    @Test
    fun `onClick opens detail for GameCardItem`() {

        val actionHandler = mockk<ActionHandler>(relaxed = true)
        val viewHolder = mockk<GameCardItem.ViewHolder>(relaxed = true)
        val view = mockk<MaterialCardView>(relaxed = true)
        val fastAdapter = mockk<FastAdapter<GenericItem>>(relaxed = true)
        val gameCardItem = mockk<GameCardItem>(relaxed = true)
        val gameModel = mockk<Game>(relaxed = true)

        every { viewHolder.binding.root } returns view
        every { gameCardItem.model } returns gameModel
        every { gameModel.id } returns 123
        every { actionHandler.openDetail(any()) } just Runs

        val eventHook = OpenDetailEvenHook(actionHandler)

        eventHook.onClick(view, 0, fastAdapter, gameCardItem)

        verify { actionHandler.openDetail(123) }
    }

    @Test
    fun `onClick opens detail for GameCardRecommendItem`() {

        val actionHandler = mockk<ActionHandler>(relaxed = true)
        val viewHolder = mockk<GameCardRecommendItem.ViewHolder>(relaxed = true)
        val view = mockk<MaterialCardView>(relaxed = true)
        val fastAdapter = mockk<FastAdapter<GenericItem>>(relaxed = true)
        val gameCardRecommendItem = mockk<GameCardRecommendItem>(relaxed = true)
        val gameModel = mockk<Game>(relaxed = true)

        every { viewHolder.binding.root } returns view
        every { gameCardRecommendItem.model } returns gameModel
        every { gameModel.id } returns 456

        val eventHook = OpenDetailEvenHook(actionHandler)

        eventHook.onClick(view, 0, fastAdapter, gameCardRecommendItem)

        verify { actionHandler.openDetail(456) }
    }
}
