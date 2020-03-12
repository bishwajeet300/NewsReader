package com.bishwajeet.newsreader.view.news.fragmentNewsFeed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.bishwajeet.newsreader.data.NewsRepository
import com.bishwajeet.newsreader.model.Article
import com.bishwajeet.newsreader.model.ArticleResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsFeedViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)
    private val _response = MutableLiveData<ArticleResult>()

    val data: LiveData<PagedList<Article>> =
        Transformations.switchMap(_response) { it.data }

    val eventNetworkError: LiveData<String> =
        Transformations.switchMap(_response) { it.networkErrors }


    init {
        getArticleList()
    }


    private fun getArticleList() {
        viewModelScope.launch {
            _response.postValue(newsRepository.getArticles())
        }
    }


    fun getColumnSpan(position: Int, currentConfiguration: Int, landscapeOrientation: Int): Int {
        return if (position % 7 == 0) {
            if (currentConfiguration == landscapeOrientation) {
                3
            } else {
                2
            }
        } else {
            1
        }
    }
}