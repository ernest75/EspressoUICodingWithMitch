package com.example.espressouicodingwithmitch.ui

import org.junit.Assert.*
import android.app.Instrumentation.*
import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.espressouicodingwithmitch.R
import com.example.espressouicodingwithmitch.ui.DirectorsFragment.Companion.stringBuilderForDirectors
import com.example.espressouicodingwithmitch.factory.MovieFragmentFactory
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DirectorsFragmentTest {

    @Test
    fun isDirectorsListCorrect() {
        // GIVEN
        val directors = arrayListOf("R.J. Stewart", "James Vanderbilt")
        val fragmentFactory = MovieFragmentFactory(null, null)
        val bundle = Bundle()
        bundle.putStringArrayList("args_directors", directors)
        val scenario = launchFragmentInContainer<DirectorsFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )

        //Verify
        onView(withId(R.id.directors_text))
            .check(matches(withText(stringBuilderForDirectors(directors))))

    }
}