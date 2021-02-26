package com.cornerjob.marvelheroes.presentation.heroesdetail

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.cornerjob.marvelheroes.R
import com.cornerjob.marvelheroes.presentation.FakeData
import com.cornerjob.marvelheroes.presentation.heroedetail.MarvelHeroDetailActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HeroesDetailActivityTest {

    private val activityTestRule = ActivityTestRule(MarvelHeroDetailActivity::class.java, false, false)

    @Test
    fun testBasicInitialization() {
        activityTestRule.launchActivity(Intent())
        onView(withText(R.string.app_name)).check(matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testDataIsLoadedSuccessfully() {
        val intent = Intent(
                InstrumentationRegistry.getInstrumentation().context,
                MarvelHeroDetailActivity::class.java
        ).apply {
            putExtra(MarvelHeroDetailActivity.PARAM_HERO, FakeData.IRON_MAN)
        }

        activityTestRule.launchActivity(intent)

        onView(withId(R.id.heroDetailName)).check(matches(withText(FakeData.NAME)))
        onView(withId(R.id.heroDetailDescription)).check(matches(withText(FakeData.DESCRIPTION)))
    }

}