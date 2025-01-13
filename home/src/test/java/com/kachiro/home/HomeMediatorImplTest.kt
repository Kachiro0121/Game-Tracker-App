package com.kachiro.home

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test


class HomeMediatorImplTest {

    @Test
    fun `startHomeScreen replaces container with HomeFragment`() {
        val fragmentManager = mockk<FragmentManager>(relaxed = true)
        val transaction = mockk<FragmentTransaction>(relaxed = true)

        every { fragmentManager.beginTransaction() } returns transaction
        every { transaction.replace(any(), any<HomeFragment>()) } returns transaction
        every { transaction.commitNow() } returns Unit

        val mediator = HomeMediatorImpl()
        mediator.startHomeScreen(1, fragmentManager)

        verify {
            fragmentManager.beginTransaction()
            transaction.replace(1, ofType(HomeFragment::class))
            transaction.commitNow()
        }
    }
}