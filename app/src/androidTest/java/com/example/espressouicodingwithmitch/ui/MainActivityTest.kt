package com.example.espressouicodingwithmitch.ui

import android.app.Activity
import android.app.Instrumentation.*
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.espressouicodingwithmitch.R
import com.example.espressouicodingwithmitch.ui.ImageViewHasDrawableMatcher.hasDrawable
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    @Test
    fun showDialogCaptureNameInput() {
        //Given
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        val EXPECTED_NAME = "Ernest"

        //Execute and verify
        onView(withId(R.id.button_launch_dialog)).perform(click())

        onView(withText(R.string.text_enter_name)).check(matches(isDisplayed()))

        onView(withText(R.string.text_ok)).perform(click())

        onView(withText(R.string.text_enter_name)).check(matches(isDisplayed()))

        //Enter input
        onView(withId(R.id.md_input_message)).perform(typeText(EXPECTED_NAME))

        onView(withText(R.string.text_ok)).perform(click())

        onView(withText(R.string.text_enter_name)).check(doesNotExist())

        onView(withId(R.id.text_name)).check(matches(withText(EXPECTED_NAME)))

    }
}