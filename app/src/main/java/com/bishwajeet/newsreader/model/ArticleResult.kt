package com.bishwajeet.newsreader.model

import androidx.lifecycle.LiveData
import androidx.paging.PagedList

/**
 * ArticleResult contains LiveData<List<Article>> holding query data,
 * and a LiveData<String> of network error state.
 */
data class ArticleResult(
    val data: LiveData<PagedList<Article>>,
    val networkErrors: LiveData<String>
)