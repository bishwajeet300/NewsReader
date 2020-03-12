package com.bishwajeet.newsreader.view.news.fragmentNewsFeed.helper

import com.bishwajeet.newsreader.model.Article

interface NewsFeedListener {

    fun onArticleClick(article: Article)
}