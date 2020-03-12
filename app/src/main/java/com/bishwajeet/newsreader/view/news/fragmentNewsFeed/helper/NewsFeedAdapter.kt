package com.bishwajeet.newsreader.view.news.fragmentNewsFeed.helper

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bishwajeet.newsreader.model.Article

class NewsFeedAdapter(private val listener: NewsFeedListener) : PagedListAdapter<Article, RecyclerView.ViewHolder>(ARTICLE_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NewsFeedListItemViewHolder.create(
            parent,
            listener
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val repoItem = getItem(position)
        if (repoItem != null) {
            (holder as NewsFeedListItemViewHolder).bind(repoItem)
        }
    }


    companion object {
        private val ARTICLE_COMPARATOR = object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean =
                oldItem.url == newItem.url

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean =
                oldItem == newItem
        }
    }
}