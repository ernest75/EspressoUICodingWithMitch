package com.example.espressouicodingwithmitch.ui


import org.junit.Assert.*
import android.app.Activity
import android.app.Instrumentation.*
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.testing.launchFragmentInContainer
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
import com.bumptech.glide.request.RequestOptions
import com.example.espressouicodingwithmitch.R
import com.example.espressouicodingwithmitch.ui.DirectorsFragment.Companion.stringBuilderForDirectors
import com.example.espressouicodingwithmitch.ui.ImageViewHasDrawableMatcher.hasDrawable
import com.example.espressouicodingwithmitch.ui.StarActorsFragment.Companion.stringBuilderForStarActors
import com.example.espressouicodingwithmitch.ui.data.Movie
import com.example.espressouicodingwithmitch.ui.data.source.MoviesDataSource
import com.example.espressouicodingwithmitch.ui.factory.MovieFragmentFactory
import io.mockk.every
import io.mockk.mockk
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matcher
import org.junit.Rule
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