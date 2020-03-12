package com.bishwajeet.newsreader.view.news.fragmentNewsFeed.helper

import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bishwajeet.newsreader.R
import com.bishwajeet.newsreader.model.Article
import com.bishwajeet.newsreader.utils.DateUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class NewsFeedListItemViewHolder(view: View, listener: NewsFeedListener) :
    RecyclerView.ViewHolder(view) {

    private val title: TextView = view.findViewById(R.id.news_title)
    private val description: TextView = view.findViewById(R.id.news_description)
    private val date: TextView = view.findViewById(R.id.news_date)
    private val source: TextView = view.findViewById(R.id.news_source)
    private val image: ImageView = view.findViewById(R.id.news_view)

    private var article: Article? = null


    init {
        view.setOnClickListener {
            if (article == null) {
                val resources = itemView.resources
                title.text = resources.getString(R.string.loading)
            } else {
                listener.onArticleClick(article!!)
            }
        }
    }


    fun bind(article: Article?) {
        if (article == null) {
            val resources = itemView.resources
            title.text = resources.getString(R.string.loading)
        } else {
            showArticle(article)
        }
    }


    private fun showArticle(article: Article) {
        this.article = article

        title.text = article.title
        description.text = article.description
        source.text = article.source.name
        date.text = DateUtils.getRelativeTimeSpanString(
            DateUtil().getFormattedDate(article.publishedAt),
            System.currentTimeMillis(),
            DateUtils.HOUR_IN_MILLIS,
            DateUtils.FORMAT_ABBREV_RELATIVE
        )

        Glide.with(image.context)
            .load(article.urlToImage)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(image)
    }



    companion object {
        fun create(parent: ViewGroup, listener: NewsFeedListener): NewsFeedListItemViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_news_feed, parent, false)
            return NewsFeedListItemViewHolder(view, listener)
        }
    }
}