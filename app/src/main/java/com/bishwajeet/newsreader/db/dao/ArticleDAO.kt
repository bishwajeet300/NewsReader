package com.bishwajeet.newsreader.db.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bishwajeet.newsreader.model.Article

@Dao
interface ArticleDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(articles: List<Article>)


    @Query("SELECT * FROM table_article")
    fun getArticles(): DataSource.Factory<Int, Article>
}