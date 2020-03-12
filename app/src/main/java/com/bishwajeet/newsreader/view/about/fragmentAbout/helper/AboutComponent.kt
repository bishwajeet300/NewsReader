package com.bishwajeet.newsreader.view.about.fragmentAbout.helper

import com.bishwajeet.newsreader.view.about.fragmentAbout.AboutFragment
import dagger.Subcomponent

@Subcomponent(modules = [AboutModule::class])
interface AboutComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): AboutComponent
    }


    fun inject(fragment: AboutFragment)
}