package com.android_academy.startfromscratch.di

import com.android_academy.network.di.MockNetworkDependency
import com.android_academy.startfromscratch.providers.MovieNetworkProvider
import com.android_academy.startfromscratch.providers.MovieNetworkProviderImpl
import java.util.concurrent.Executors
import java.util.concurrent.ThreadPoolExecutor

object DependencyInjection {
    val networkProvider: MovieNetworkProvider =
        MovieNetworkProviderImpl(MockNetworkDependency.movieService)

    val viewModelExecutor: ThreadPoolExecutor =
        Executors.newFixedThreadPool(10) as ThreadPoolExecutor
}