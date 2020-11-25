package com.android_academy.network.di

import com.android_academy.network.MoviesListResult
import com.google.gson.Gson

object MockNetworkDependency {
    val movieService = object : MockMovieService {
        override fun latestMovies(year: Int, apiKey: String): MoviesListResult {
            val gson = Gson()
            return gson.fromJson(mockData, MoviesListResult::class.java)
        }
    }
}