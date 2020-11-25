package com.android_academy.startfromscratch.di

import com.android_academy.db.MovieDao
import com.android_academy.db.di.MockDBDependency
import com.android_academy.network.di.MockNetworkDependency
import com.android_academy.startfromscratch.providers.MovieDatabaseProvider
import com.android_academy.startfromscratch.providers.MovieDatabaseProviderImpl
import com.android_academy.startfromscratch.repository.MoviesRepository
import com.android_academy.startfromscratch.repository.MoviesRepositoryImpl
import com.android_academy.startfromscratch.providers.MovieNetworkProvider
import com.android_academy.startfromscratch.providers.MovieNetworkProviderImpl
import com.android_academy.network.MoviesService
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor

object DependencyInjection {
    //TODO change MockDBDependency to DBDependency and remove casting
    val dbProvider: MovieDatabaseProvider = MovieDatabaseProviderImpl(MockDBDependency.getMoviesDao() as MovieDao)

    //TODO change MockNetworkDependency to NetworkDependency and remove casting
    val networkProvider: MovieNetworkProvider = MovieNetworkProviderImpl(MockNetworkDependency.movieService as MoviesService)

    val moviesRepo: MoviesRepository = MoviesRepositoryImpl(dbProvider, networkProvider)

    val viewModelExecutor: ThreadPoolExecutor =
        Executors.newFixedThreadPool(10) as ThreadPoolExecutor
}