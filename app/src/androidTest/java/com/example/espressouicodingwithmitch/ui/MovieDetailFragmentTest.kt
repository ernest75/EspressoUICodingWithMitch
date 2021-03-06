package com.example.espressouicodingwithmitch.ui

import org.junit.Assert.*
import android.app.Instrumentation.*
import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.bumptech.glide.request.RequestOptions
import com.example.espressouicodingwithmitch.R
import com.example.espressouicodingwithmitch.data.Movie
import com.example.espressouicodingwithmitch.data.source.MoviesDataSource
import com.example.espressouicodingwithmitch.factory.MovieFragmentFactory
import io.mockk.every
import io.mockk.mockk
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MovieDetailFragmentTest{


    @Test
    fun isMovieDataVisible() {
        // SETUP
        val movieId = 1
        val title = "The Rundown"
        val description =
            "A tough aspiring chef is hired to bring home a mobster's son from the Amazon but " +
                    "becomes involved in the fight against an oppressive town operator and the search " +
                    "for a legendary treasure."
        val movie = Movie(
            movieId,
            title,
            "https://nyc3.digitaloceanspaces.com/open-api-spaces/open-api-static/blog/1/The_Rundown-the_rundown.png",
            description,
            arrayListOf("R.J. Stewart", "James Vanderbilt"),
            arrayListOf(
                "Dwayne Johnson",
                "Seann William Scott",
                "Rosario Dawson",
                "Christopher Walken"
            )
        )

        val movieDataSource = mockk<MoviesDataSource>()
        every {
            movieDataSource.getMovie(any())
        } returns movie

        val requestOptions = RequestOptions()
            .placeholder(R.drawable.default_image)
            .error(R.drawable.default_image)

        val fragmentFactory = MovieFragmentFactory(requestOptions,movieDataSource)
        val bundle = Bundle()
        bundle.putInt("movie_id",movieId)
        val scenario = launchFragmentInContainer<MovieDetailFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )

        //Verify
        onView(withId(R.id.movie_title)).check(matches(withText(title)))
        onView(withId(R.id.movie_description)).check(matches(withText(description)))

    }
}