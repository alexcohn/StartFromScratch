package com.android_academy.startfromscratch.ui.mainMovies

import com.android_academy.startfromscratch.db.Movie

interface OnMovieClickListener {
    //TODO Exercise #1 Fix import of Movie class after you move network to separate module
    fun onMovieClicked(movie: Movie, adapterPosition: Int)

}