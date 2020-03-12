package com.bishwajeet.newsreader.model

import androidx.room.Ignore
import com.google.gson.annotations.SerializedName

data class Source(
    @Ignore
    @SerializedName("id")
    val id: Any? = Any(),

    @SerializedName("name")
    var name: String = ""
)