package com.example.espressouicodingwithmitch.ui.data.source

import com.example.espressouicodingwithmitch.ui.data.Movie

interface MoviesDataSource {

    fun getMovie(movieId: Int): Movie?
}