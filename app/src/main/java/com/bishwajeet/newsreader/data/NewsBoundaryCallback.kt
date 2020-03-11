package com.bishwajeet.newsreader.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.bishwajeet.newsreader.api.APIService
import com.bishwajeet.newsreader.api.getNewsResponse
import com.bishwajeet.newsreader.db.ArticleDataCache
import com.bishwajeet.newsreader.model.Article

class NewsBoundaryCallback(
    private val network: APIService,
    private val local: ArticleDataCache
) : PagedList.BoundaryCallback<Article>() {

    // avoid triggering multiple requests in the same time
    private var isRequestInProgress = false

    // keep the last requested page. When the request is successful, increment the page number.
    private var lastRequestedPage = 1

    // LiveData of network errors.
    private val _networkErrors = MutableLiveData<String>()

    // LiveData of network errors.
    val networkErrors: LiveData<String>
        get() = _networkErrors


    override fun onZeroItemsLoaded() {
        println("onZeroItemsLoaded")
        requestAndSaveData()
    }


    override fun onItemAtEndLoaded(itemAtEnd: Article) {
        println("onItemAtEndLoaded $itemAtEnd")
        requestAndSaveData()
    }


    private fun requestAndSaveData() {
        if (isRequestInProgress) return

        isRequestInProgress = true

        getNewsResponse(network, "android", "05dc83fa047b45399fa2632af32f4a2b", lastRequestedPage, NETWORK_PAGE_SIZE, { articles ->
            if (articles.isNotEmpty()) {
                local.insert(articles) {
                    lastRequestedPage++
                    println("local.insert $lastRequestedPage")
                    isRequestInProgress = false
                }
            }

        }, { error ->
            _networkErrors.postValue(error)
            println("_networkErrors $error")
            isRequestInProgress = false
        })
    }


    companion object {
        private const val NETWORK_PAGE_SIZE = 21
    }
}