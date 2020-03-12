package com.bishwajeet.newsreader.utils

class ColumnSpanUtil {

    internal fun getColumnSpan(position: Int, currentConfiguration: Int, landscapeOrientation: Int): Int {
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