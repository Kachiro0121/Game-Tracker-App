package com.kachiro.game_catalog

import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import io.mockk.mockk
import io.mockk.slot
import io.mockk.unmockkAll
import io.mockk.verify
import org.junit.After
import org.junit.Before
import org.junit.Test

class CatalogMediatorImplTest {


    private lateinit var catalogMediator: CatalogMediatorImpl
    private lateinit var router: Router

    @Before
    fun setUp() {
        router = mockk(relaxed = true)

        catalogMediator = CatalogMediatorImpl(router)
    }

    @After
    fun tearDown() {
        unmockkAll()
    }

    @Test
    fun `openScreenCatalog calls replaceScreen with catalogScreen`() {
        val screenSlot = slot<FragmentScreen>()

        catalogMediator.openScreenCatalog()

        verify { router.replaceScreen(capture(screenSlot)) }

        val fragmentFactory = mockk<FragmentFactory>(relaxed = true)
        val fragment = screenSlot.captured.createFragment(fragmentFactory)

        assert(fragment is CatalogFragment) {
            "Expected CatalogFragment, but got ${fragment::class.simpleName}"
        }
    }
}