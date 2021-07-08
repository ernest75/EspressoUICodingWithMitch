package com.example.espressouicodingwithmitch.data.source

import com.example.espressouicodingwithmitch.data.Movie

interface MoviesDataSource {

    fun getMovie(movieId: Int): Movie?
    fun getMovies(): List<Movie>
}