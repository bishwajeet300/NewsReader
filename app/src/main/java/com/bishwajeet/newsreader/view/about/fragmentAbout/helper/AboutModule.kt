package com.bishwajeet.newsreader.view.about.fragmentAbout.helper

import androidx.lifecycle.ViewModel
import com.bishwajeet.newsreader.di.ViewModelKey
import com.bishwajeet.newsreader.view.about.fragmentAbout.AboutViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AboutModule {

    @Binds
    @IntoMap
    @ViewModelKey(AboutViewModel::class)
    abstract fun bindViewModel(viewModel: AboutViewModel): ViewModel
}