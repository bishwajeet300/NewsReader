package com.bishwajeet.newsreader.model

import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "table_article")
data class Article(
    @Embedded
    @SerializedName("source")
    val source: Source = Source(),
    @SerializedName("author")
    val author: String? = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("description")
    val description: String? = "",
    @PrimaryKey
    @SerializedName("url")
    val url: String = "",
    @SerializedName("urlToImage")
    val urlToImage: String? = "",
    @SerializedName("publishedAt")
    val publishedAt: String = "",
    @SerializedName("content")
    val content: String? = ""
) {

}