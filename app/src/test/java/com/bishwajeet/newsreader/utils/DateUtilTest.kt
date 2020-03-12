package com.bishwajeet.newsreader.utils

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class DateUtilTest {

    @Test
    fun getReadableTime_validPattern_returnsCorrect() {
        //Given
        val publishedAt = SAMPLE_VALID_DATE

        //When
        val result = DateUtil().getFormattedDate(publishedAt)

        //Then
        Assert.assertEquals(result, CORRECT_TIMESTAMP)
    }


    @Test
    fun getReadableTime_invalidPattern_returnsIncorrect() {
        //Given
        val publishedAt = SAMPLE_INVALID_DATE

        //When
        val result = DateUtil().getFormattedDate(publishedAt)

        //Then
        Assert.assertNotEquals(result, CORRECT_TIMESTAMP)
    }


    @Test
    fun getReadableTime_invalidPattern_returnsNonCorrect() {
        //Given
        val publishedAt = SAMPLE_INVALID_DATE

        //When
        val result = DateUtil().getFormattedDate(publishedAt)

        //Then
        Assert.assertNotEquals(result, CORRECT_TIMESTAMP)
    }


    companion object {
        const val SAMPLE_VALID_DATE = "2020-03-12T14:12:16Z"
        const val SAMPLE_INVALID_DATE = "2020-03-11T12:00:00Z"
        const val CORRECT_TIMESTAMP = 1584002536000
    }
}