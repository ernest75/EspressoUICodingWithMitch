package com.example.espressouicodingwithmitch.ui


import org.junit.Assert.*
import android.app.Instrumentation.*
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.espressouicodingwithmitch.R
import com.example.espressouicodingwithmitch.data.FakeMovieData
import com.example.espressouicodingwithmitch.util.EspressoIdlingResource
import com.example.espressouicodingwithmitch.util.IdlingResourceRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MovieListFragmentTest{

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    val idlingResourceRule = IdlingResourceRule()

    val LIST_ITEM_IN_TEST = 4
    val MOVIE_IN_TEST = FakeMovieData.movies[LIST_ITEM_IN_TEST]

    @Before
    fun registerIdlingResource(){
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
    }

    @After
    fun unregisterIdlingResource(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource)

    }

    /**
     * Recyclerview comes into view
     */
    @Test
    fun isListFragmentIsVisible() {
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))
    }

    /**
     * Select list item, nav to detail correct movie is in view
     */
    @Test
    fun navToDetailIsCorrectMovieShown() {
        onView(withId(R.id.recycler_view))
            .perform(actionOnItemAtPosition<MoviesListAdapter.MovieViewHolder>(LIST_ITEM_IN_TEST,
                click()))
        onView(withId(R.id.movie_title)).check(matches(withText(MOVIE_IN_TEST.title)))
    }

    /**
     * Select list item, nav to detail frgment
     * press back
     */
    @Test
    fun navToDetailNavBack() {
        onView(withId(R.id.recycler_view))
            .perform(actionOnItemAtPosition<MoviesListAdapter.MovieViewHolder>(LIST_ITEM_IN_TEST,
                click()))
        onView(withId(R.id.movie_title)).check(matches(withText(MOVIE_IN_TEST.title)))
        pressBack()
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))
    }

    /**
     * Select list item, nav to detail press directors nav to directors
     */
    @Test
    fun navToDetailNavToDirectors() {
        onView(withId(R.id.recycler_view))
            .perform(actionOnItemAtPosition<MoviesListAdapter.MovieViewHolder>(LIST_ITEM_IN_TEST,
                click()))
        onView(withId(R.id.movie_directiors)).perform(click())
        onView(withId(R.id.directors_text))
            .check(matches(withText(DirectorsFragment.stringBuilderForDirectors(MOVIE_IN_TEST.directors!!))))
    }

    /**
     * Select list item, nav to detail press actors nav to actors
     */
    @Test
    fun navToDetailNavToActors() {
        onView(withId(R.id.recycler_view))
            .perform(actionOnItemAtPosition<MoviesListAdapter.MovieViewHolder>(LIST_ITEM_IN_TEST,
                click()))
        onView(withId(R.id.movie_star_actors)).perform(click())
        onView(withId(R.id.star_actors_text))
            .check(matches(withText(DirectorsFragment.stringBuilderForDirectors(MOVIE_IN_TEST.star_actors!!))))
    }
}