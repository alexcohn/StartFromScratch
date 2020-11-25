package com.android_academy.startfromscratch.ui.details

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android_academy.db.Movie
import com.android_academy.startfromscratch.di.DependencyInjection
import com.android_academy.startfromscratch.repository.MoviesRepository

interface DetailsViewModel {
    fun observeMovieDetails(lifecycle: Lifecycle, observer: (Movie) -> Unit)
    fun loadMovie(movieId: Int)
}

class DetailsViewModelImpl(private val moviesRepository: MoviesRepository) : ViewModel(),
    DetailsViewModel {

    private val executors = DependencyInjection.viewModelExecutor

    private val movieLiveData = MutableLiveData<Movie>()

    override fun observeMovieDetails(lifecycle: Lifecycle, observer: (Movie) -> Unit) {
        movieLiveData.observe({ lifecycle }) {
            observer(it)
        }
    }

    override fun loadMovie(movieId: Int) {
        executors.execute {
            //TODO Call for getMovie(movieId) on Repository
            //TODO Update live data on new received movie
            //notice that now our data will come from DB and not from network.
            //since our LiveData story movie it will cached for next call (e.g. after activity recreation)
        }
    }
}

class DetailsViewModelFactory(private val moviesRepository: MoviesRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsViewModelImpl::class.java)) {
            return DetailsViewModelImpl(moviesRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
