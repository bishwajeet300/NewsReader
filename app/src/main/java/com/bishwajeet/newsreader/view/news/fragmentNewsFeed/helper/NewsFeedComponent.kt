package com.bishwajeet.newsreader.view.news.fragmentNewsFeed.helper

import com.bishwajeet.newsreader.view.news.fragmentNewsFeed.NewsFeedFragment
import dagger.Subcomponent

@Subcomponent(modules = [NewsFeedModule::class])
interface NewsFeedComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): NewsFeedComponent
    }


    fun inject(fragment: NewsFeedFragment)
}