package com.bishwajeet.newsreader.utils

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ColumnSpanUtilTest {

    @Test
    fun getColumnSpan_exactPositionInPortrait_returnsTwo() {
        //Given
        val position = 21
        val currentConfiguration = ORIENTATION_PORTRAIT

        //When
        val result =
            ColumnSpanUtil().getColumnSpan(position, currentConfiguration, ORIENTATION_LANDSCAPE)

        //Then
        Assert.assertEquals(result, COL_SPAN_PORTRAIT)
    }


    @Test
    fun getColumnSpan_exactPositionInLandscape_returnsThree() {
        //Given
        val position = 21
        val currentConfiguration = ORIENTATION_LANDSCAPE

        //When
        val result =
            ColumnSpanUtil().getColumnSpan(position, currentConfiguration, ORIENTATION_LANDSCAPE)

        //Then
        Assert.assertEquals(result, COL_SPAN_LANDSCAPE)
    }


    @Test
    fun getColumnSpan_nonExactPositionInPortrait_returnsOne() {
        //Given
        val position = 20
        val currentConfiguration = ORIENTATION_PORTRAIT

        //When
        val result =
            ColumnSpanUtil().getColumnSpan(position, currentConfiguration, ORIENTATION_LANDSCAPE)

        //Then
        Assert.assertEquals(result, COL_SPAN_PER_ITEM)
    }


    @Test
    fun getColumnSpan_nonExactPositionInLandscape_returnsOne() {
        //Given
        val position = 20
        val currentConfiguration = ORIENTATION_LANDSCAPE

        //When
        val result =
            ColumnSpanUtil().getColumnSpan(position, currentConfiguration, ORIENTATION_LANDSCAPE)

        //Then
        Assert.assertEquals(result, COL_SPAN_PER_ITEM)
    }


    companion object {
        const val ORIENTATION_PORTRAIT = 1
        const val ORIENTATION_LANDSCAPE = 2
        const val COL_SPAN_LANDSCAPE = 3
        const val COL_SPAN_PORTRAIT = 2
        const val COL_SPAN_PER_ITEM = 1
    }
}