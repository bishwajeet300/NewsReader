package com.bishwajeet.newsreader

import android.app.Application
import com.bishwajeet.newsreader.di.ApplicationComponent
import com.bishwajeet.newsreader.di.DaggerApplicationComponent

class NewReaderApp: Application() {

    val applicationComponent: ApplicationComponent by lazy {
        initializeComponent()
    }


    fun initializeComponent(): ApplicationComponent {
        // Creates an instance of ApplicationComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        return DaggerApplicationComponent.factory().create(applicationContext)
    }
}