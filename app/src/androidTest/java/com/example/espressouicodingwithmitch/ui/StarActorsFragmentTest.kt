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
import com.example.espressouicodingwithmitch.ui.StarActorsFragment.Companion.stringBuilderForStarActors
import com.example.espressouicodingwithmitch.factory.MovieFragmentFactory
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class StarActorsFragmentTest{
    @Test
    fun isActorsListCorrect() {
        // GIVEN
        val actors = arrayListOf("Lord", "Ernest", "El", "Més LLest")
        val fragmentFactory = MovieFragmentFactory(null, null)
        val bundle = Bundle()
        bundle.putStringArrayList("args_actors",actors)
        val scenario = launchFragmentInContainer<StarActorsFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )

        //Verify
        onView(withId(R.id.star_actors_text))
            .check(matches(withText(stringBuilderForStarActors(actors))))

    }
}