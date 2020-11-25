package com.android_academy.startfromscratch

import android.app.Application
import android.content.Context

class MoviesApp : Application() {
    init {
        instance = this
    }

    companion object {
        private var instance: MoviesApp? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }
}