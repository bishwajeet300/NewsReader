package com.bishwajeet.newsreader.model

import androidx.room.ColumnInfo
import androidx.room.Ignore
import com.google.gson.annotations.SerializedName

data class Source(
    @Ignore
    @SerializedName("id")
    val id: Any? = Any(),

    @ColumnInfo(name = "source_name")
    @SerializedName("name")
    val name: String = ""
)