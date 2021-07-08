package com.example.espressouicodingwithmitch.util

import android.text.TextWatcher
import androidx.test.espresso.IdlingRegistry
import org.junit.rules.TestRule
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.junit.runners.model.Statement

/**
 * Option 1:extend test rule
 * Option 2 : extend text watcher that extends test rule
 */
class IdlingResourceRule : TestWatcher() {

    private val idlingResource = EspressoIdlingResource.countingIdlingResource

    override fun starting(description: Description?) {
        super.starting(description)
        IdlingRegistry.getInstance().register(idlingResource)
    }

    override fun finished(description: Description?) {
        IdlingRegistry.getInstance().unregister(idlingResource)
        super.finished(description)
    }
}

