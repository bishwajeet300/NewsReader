package com.bishwajeet.newsreader.di

import com.bishwajeet.newsreader.view.about.fragmentAbout.helper.AboutComponent
import com.bishwajeet.newsreader.view.news.fragmentNewsFeed.helper.NewsFeedComponent
import com.bishwajeet.newsreader.view.news.fragmentNewsReader.helper.NewsReaderComponent
import dagger.Module

@Module(
    subcomponents = [
        NewsFeedComponent::class,
        NewsReaderComponent::class,
        AboutComponent::class
    ]
)
object SubcomponentModule {
}