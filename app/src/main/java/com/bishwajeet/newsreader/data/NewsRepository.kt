package com.bishwajeet.newsreader.data

import androidx.paging.LivePagedListBuilder
import com.bishwajeet.newsreader.api.APIService
import com.bishwajeet.newsreader.db.ArticleDataCache
import com.bishwajeet.newsreader.model.ArticleResult

class NewsRepository(
    private val network: APIService,
    private val local: ArticleDataCache
) {

    fun getArticles(): ArticleResult {

        // Get data source factory from the local cache
        val dataSourceFactory = local.getArticles()
        val boundaryCallback = NewsBoundaryCallback(network, local)
        val networkErrors = boundaryCallback.networkErrors

        // Get the paged list
        val data = LivePagedListBuilder(dataSourceFactory, DATABASE_PAGE_SIZE)
            .setBoundaryCallback(boundaryCallback)
            .build()

        // Get the network errors exposed by the boundary callback
        return ArticleResult(data, networkErrors)
    }


    companion object {
        private const val DATABASE_PAGE_SIZE = 21
    }
}