package com.example.espressouicodingwithmitch.ui.movie

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.runner.RunWith
import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.espressouicodingwithmitch.R
import com.example.espressouicodingwithmitch.data.DummyMovies.THE_RUNDOWN
import com.example.espressouicodingwithmitch.factory.MovieFragmentFactory
import org.junit.Assert.*
import org.junit.Test


@RunWith(AndroidJUnit4ClassRunner::class)
class StarActorsFragmentTest{

    @Test
    fun actorsListIsCorrect() {
        //Setup
        val directors =  arrayListOf("Lord", "Ernest")
        val fragmentFactory = MovieFragmentFactory()
        val bundle = Bundle()
        bundle.putStringArrayList("args_actors",directors)

        launchFragmentInContainer<StarActorsFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )

        onView(withId(R.id.star_actors_text)).check(
            matches(withText(DirectorsFragment.stringBuilderForDirectors(directors))))

    }


}