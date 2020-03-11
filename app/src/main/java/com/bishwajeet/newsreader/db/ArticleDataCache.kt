package com.bishwajeet.newsreader.db

import android.util.Log
import androidx.paging.DataSource
import com.bishwajeet.newsreader.db.dao.ArticleDAO
import com.bishwajeet.newsreader.model.Article
import java.util.concurrent.Executor

class ArticleDataCache(
    private val articleDAO: ArticleDAO,
    private val ioExecutor: Executor
) {
    /**
     * Insert a list of repos in the database, on a background thread.
     */
    fun insert(articles: List<Article>, insertFinished: () -> Unit) {
        ioExecutor.execute {
            Log.d("ArticleDataCache", "inserting ${articles.size} repos")
            articleDAO.insert(articles)
            insertFinished()
        }
    }

    fun getRepos(): DataSource.Factory<Int, Article> {
        return articleDAO.getArticles()
    }
}