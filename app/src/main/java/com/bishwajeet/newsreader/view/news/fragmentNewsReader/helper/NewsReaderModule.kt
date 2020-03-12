package com.bishwajeet.newsreader.view.news.fragmentNewsReader.helper

import androidx.lifecycle.ViewModel
import com.bishwajeet.newsreader.di.ViewModelKey
import com.bishwajeet.newsreader.view.news.fragmentNewsReader.NewsReaderViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class NewsReaderModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewsReaderViewModel::class)
    abstract fun bindViewModel(viewModel: NewsReaderViewModel): ViewModel
}