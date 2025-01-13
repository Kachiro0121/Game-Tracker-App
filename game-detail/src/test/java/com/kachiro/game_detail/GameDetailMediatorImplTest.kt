package com.kachiro.game_detail

import androidx.fragment.app.FragmentFactory
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GameDetailMediatorImplTest {

    private lateinit var gameDetailMediator: GameDetailMediatorImpl
    private val router: Router = mockk(relaxed = true)

    @Before
    fun setUp() {
        gameDetailMediator = GameDetailMediatorImpl(router)
    }

    @Test
    fun `openScreenDetailGame calls navigateTo with correct screen`() {
        val gameId = 1

        val screenSlot = slot<FragmentScreen>()

        gameDetailMediator.openScreenDetailGame(gameId)

        verify { router.navigateTo(capture(screenSlot)) }

        val fragmentFactory = mockk<FragmentFactory>(relaxed = true) // Мок FragmentFactory
        val fragment = screenSlot.captured.createFragment(fragmentFactory)

        assert(fragment is GameDetailFragment) {
            "Expected GameDetailFragment, but got ${fragment::class.simpleName}"
        }
    }
}