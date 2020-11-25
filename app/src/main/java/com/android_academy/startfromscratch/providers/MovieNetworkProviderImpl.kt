package com.android_academy.startfromscratch.providers

import com.android_academy.network.di.MockMovieService
import com.android_academy.network.MoviesListResult

interface MovieNetworkProvider {
    fun getMovies(): MoviesListResult?
}

class MovieNetworkProviderImpl(private val service: MockMovieService) : MovieNetworkProvider {

    override fun getMovies(): MoviesListResult? {
        return try {
            service.latestMovies()
        } catch (e: Throwable) {
            null
        }
    }
}