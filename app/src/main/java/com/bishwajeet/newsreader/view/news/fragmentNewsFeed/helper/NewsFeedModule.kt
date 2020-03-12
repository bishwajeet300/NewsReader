package com.bishwajeet.newsreader.view.news.fragmentNewsFeed.helper

import androidx.lifecycle.ViewModel
import com.bishwajeet.newsreader.di.ViewModelKey
import com.bishwajeet.newsreader.view.news.fragmentNewsFeed.NewsFeedViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class NewsFeedModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewsFeedViewModel::class)
    abstract fun bindViewModel(viewModel: NewsFeedViewModel): ViewModel
}