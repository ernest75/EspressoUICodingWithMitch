package com.example.espressouicodingwithmitch.ui.movie

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.runner.RunWith
import org.junit.Assert.*
import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.espressouicodingwithmitch.R
import com.example.espressouicodingwithmitch.data.DummyMovies.THE_RUNDOWN
import com.example.espressouicodingwithmitch.factory.MovieFragmentFactory
import org.junit.Assert.*
import org.junit.Test

@RunWith(AndroidJUnit4ClassRunner::class)
class NavigationTests{

    @Test
    fun fragmentsNavigation() {

        //SETUP
        ActivityScenario.launch(MainActivity::class.java)

        //Nav directions fragments
        onView(withId(R.id.movie_directiors)).perform(click())

        //Verify
        onView(withId(R.id.diretcors_fragment_parent)).check(matches(isDisplayed()))

        pressBack()

        //Verify
        onView(withId(R.id.detail_movie_fragment_parent)).check(matches(isDisplayed()))

        onView(withId(R.id.movie_star_actors)).perform(click())

        //Verify
        onView(withId(R.id.star_actors_fragment_parent)).check(matches(isDisplayed()))



    }
}