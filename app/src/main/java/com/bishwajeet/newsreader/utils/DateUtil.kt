package com.bishwajeet.newsreader.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateUtil {

    internal fun getFormattedDate(publishedAt: String): Long {
        return try {
            val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
            @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS") val date: Date = sdf.parse(publishedAt)
            val startDate: Long = date.time
            startDate
        } catch (e: ParseException) {
            e.printStackTrace()
            System.currentTimeMillis()
        }
    }

}