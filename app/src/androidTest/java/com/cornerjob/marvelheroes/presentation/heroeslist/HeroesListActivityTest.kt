package com.cornerjob.marvelheroes.presentation.heroeslist

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.cornerjob.marvelheroes.R
import com.cornerjob.marvelheroes.presentation.heroedetail.MarvelHeroDetailActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HeroesListActivityTest {

    val activityTestRule = ActivityTestRule<HeroesListActivity>(HeroesListActivity::class.java)

    @Test
    fun testBasicInitialization() {
        activityTestRule.launchActivity(Intent())

        onView(withText(R.string.app_name)).check(matches(isDisplayed()))
    }

    @Test
    fun testClickOnItemAndOpenDetailActivity() {
        Intents.init()
        activityTestRule.launchActivity(Intent())

        // This is very bad I would like to implement Idling Resources
        // with https://github.com/JakeWharton/okhttp-idling-resource
        Thread.sleep(1000)

        onView(withId(R.id.heroesListRecycler))
                .perform(RecyclerViewActions.actionOnItemAtPosition<HeroesListAdapter.HeroesViewHolder>(0, click()))

        intended(hasComponent(MarvelHeroDetailActivity::class.java.name))

        Intents.release()
    }

}