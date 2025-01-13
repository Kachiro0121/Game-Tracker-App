package com.kachiro.gametrackerapp

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kachiro.game_catalog.CatalogFragment
import com.kachiro.game_catalog.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CatalogFragmentTest {

    @Test
    fun catalogFragmentTest() {

        launchFragmentInContainer(
            themeResId = com.kachiro.uikit.R.style.Theme_GameTrackerApp
        ) { CatalogFragment.newInstance() }

        onView(withId(R.id.catalog))
            .check(matches(isDisplayed()))

        onView(withId(R.id.filter))
            .perform(click())

        onView(withText(R.string.filter_options))
            .check(matches(isDisplayed()))

        onView(withText(R.string.moba))
            .perform(click())

        onView(withText("APPLY"))
            .perform(click())

        onView(withId(R.id.catalog))
            .check(matches(hasDescendant(withText("Minion Masters"))))
    }
}