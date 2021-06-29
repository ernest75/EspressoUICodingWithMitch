package com.example.espressouicodingwithmitch

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class NavigationTest {

    @Test
    fun navigateToDetail() {
        ActivityScenario.launch(MainActivity::class.java)

        onView(ViewMatchers.withId(R.id.button_next_activity)).perform(ViewActions.click())
        onView(ViewMatchers.withId(R.id.activity_secondary_title)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
    }

    @Test
    fun navigateBackToMain() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(ViewMatchers.withId(R.id.button_next_activity)).perform(ViewActions.click())

        onView(ViewMatchers.withId(R.id.button_back)).perform(ViewActions.click())
        onView(ViewMatchers.withId(R.id.activity_main_title)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )

    }
}