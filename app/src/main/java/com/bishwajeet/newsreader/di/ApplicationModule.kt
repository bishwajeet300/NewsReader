package com.bishwajeet.newsreader.di

import android.content.Context
import com.bishwajeet.newsreader.api.APIService
import com.bishwajeet.newsreader.db.ApplicationDatabase
import com.bishwajeet.newsreader.db.ArticleDataCache
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
abstract class ApplicationModule {

    @Module
    companion object {

        @JvmStatic
        @Singleton
        @Provides
        fun provideAPIService(): APIService {
            return APIService.create()
        }


        @JvmStatic
        @Singleton
        @Provides
        fun provideArticleCache(context: Context): ArticleDataCache {
            val database = ApplicationDatabase.getDatabase(context)
            return ArticleDataCache(
                database.getArticleDAO(),
                Executors.newSingleThreadExecutor()
            )
        }
    }
}