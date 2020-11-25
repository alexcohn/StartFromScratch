package com.android_academy.startfromscratch.di

import com.android_academy.db.di.MockDBDependency
import com.android_academy.network.di.MockNetworkDependency
import com.android_academy.startfromscratch.providers.MovieDatabaseProvider
import com.android_academy.startfromscratch.providers.MovieDatabaseProviderImpl
import com.android_academy.startfromscratch.repository.MoviesRepository
import com.android_academy.startfromscratch.repository.MoviesRepositoryImpl
import com.android_academy.startfromscratch.providers.MovieNetworkProvider
import com.android_academy.startfromscratch.providers.MovieNetworkProviderImpl
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor

object DependencyInjection {
    //I'm tired of implementing safe thread for all this manual dependency injection.
    val dbProvider: MovieDatabaseProvider =
        MovieDatabaseProviderImpl(MockDBDependency.getMoviesDao())

    val repoExecutor: ThreadPoolExecutor = Executors.newFixedThreadPool(10) as ThreadPoolExecutor

    val networkProvider: MovieNetworkProvider =
        MovieNetworkProviderImpl(MockNetworkDependency.movieService)

    val moviesRepo: MoviesRepository =
        MoviesRepositoryImpl(dbProvider, networkProvider, repoExecutor)

    val viewModelExecutor: ThreadPoolExecutor =
        Executors.newFixedThreadPool(10) as ThreadPoolExecutor
}