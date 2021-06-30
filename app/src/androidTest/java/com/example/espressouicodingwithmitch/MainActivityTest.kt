package com.example.espressouicodingwithmitch

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    @Test
    fun testActivityInView() {
        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.main)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    @Test
    fun testNextButtonIsDisplayed() {
        ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.button_next_activity)).check(matches(isDisplayed()))
        onView(withId(R.id.button_next_activity)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

    }

    @Test
    fun testVisibilityTitle() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.activity_main_title)).check(matches(withText(R.string.text_mainactivity)))
    }

}