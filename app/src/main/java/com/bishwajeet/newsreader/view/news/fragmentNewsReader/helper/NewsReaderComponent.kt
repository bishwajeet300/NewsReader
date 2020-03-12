package com.bishwajeet.newsreader.view.news.fragmentNewsReader.helper

import com.bishwajeet.newsreader.view.news.fragmentNewsReader.NewsReaderFragment
import dagger.Subcomponent

@Subcomponent(modules = [NewsReaderModule::class])
interface NewsReaderComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): NewsReaderComponent
    }


    fun inject(fragment: NewsReaderFragment)
}