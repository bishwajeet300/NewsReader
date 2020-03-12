package com.bishwajeet.newsreader.view.news.fragmentNewsReader

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.bishwajeet.newsreader.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NewsReaderFragmentTest {

    @Test
    fun testEventFragment() {
        val fragmentArgs = Bundle().apply {
            putString("URL", "https://lifehacker.com/how-to-update-your-super-old-android-so-it-doesnt-get-h-1842157601")
        }
        val scenario = launchFragmentInContainer<NewsReaderFragment>(
            fragmentArgs
        )
        onView(withId(R.id.webview)).check(matches(withId(R.id.webview)))
    }
}