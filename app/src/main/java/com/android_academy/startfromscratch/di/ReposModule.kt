package com.android_academy.startfromscratch.di

import com.android_academy.startfromscratch.providers.MovieDatabaseProvider
import com.android_academy.startfromscratch.providers.MovieDatabaseProviderImpl
import com.android_academy.startfromscratch.providers.MovieNetworkProvider
import com.android_academy.startfromscratch.providers.MovieNetworkProviderImpl
import com.android_academy.startfromscratch.repository.MoviesRepository
import com.android_academy.startfromscratch.repository.MoviesRepositoryImpl
import org.koin.dsl.module


val reposModule = module {

    //TODO change it to single since we want our repo to be a singleton
    factory<MoviesRepository> {
        MoviesRepositoryImpl(
            dbProvider = get(),
            networkProvider = get()
        )
    }

    single<MovieNetworkProvider> {
        MovieNetworkProviderImpl(get())
    }

    single<MovieDatabaseProvider> {
        MovieDatabaseProviderImpl(get())
    }
}