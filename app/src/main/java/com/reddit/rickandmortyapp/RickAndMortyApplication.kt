package com.reddit.rickandmortyapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RickAndMortyApplication :Application(){
    override fun onCreate() {
        super.onCreate()
    }
}
