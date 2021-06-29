package com.example.espressouicodingwithmitch

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SecondaryActivityTest{

    @get:Rule
    val activityRule = ActivityScenarioRule(SecondaryActivity::class.java)

    @Test
    fun buttonIsDisplayedWithCorrectText() {

        onView(withId(R.id.button_back)).check(matches(isDisplayed()))
        onView(withId(R.id.button_back)).check(matches(withText(R.string.text_back)))
    }

    @Test
    fun titleIsCorrect() {

        onView(withId(R.id.activity_secondary_title)).check(matches(isDisplayed()))
        onView(withId(R.id.activity_secondary_title)).check(matches(withText(R.string.text_secondaryactivity)))

    }
}