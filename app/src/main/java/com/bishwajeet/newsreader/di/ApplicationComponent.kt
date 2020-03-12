package com.bishwajeet.newsreader.di

import android.content.Context
import com.bishwajeet.newsreader.api.APIService
import com.bishwajeet.newsreader.view.about.fragmentAbout.helper.AboutComponent
import com.bishwajeet.newsreader.view.news.fragmentNewsFeed.helper.NewsFeedComponent
import com.bishwajeet.newsreader.view.news.fragmentNewsReader.helper.NewsReaderComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ApplicationModule::class, ViewModelBuilderModule::class, SubcomponentModule::class]
)
interface ApplicationComponent {

    /*
    * Makes DependencyGraph ito be available to other Android framework classes
    * */
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }


    /*
    * Components & SubComponents
    * */
    fun newsFeedComponent(): NewsFeedComponent.Factory

    fun newsReaderComponent(): NewsReaderComponent.Factory

    fun aboutComponent(): AboutComponent.Factory


    /*
    * Return single instance
    * */
    val networkService: APIService
}