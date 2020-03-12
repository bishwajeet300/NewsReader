package com.bishwajeet.newsreader.view.about.fragmentAbout

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.bishwajeet.newsreader.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AboutFragmentTest {

    @Test
    fun testEventFragment() {
        val scenario = launchFragmentInContainer<AboutFragment>()
        Espresso.onView(ViewMatchers.withId(R.id.tvHeading))
            .check(ViewAssertions.matches(ViewMatchers.withText(R.string.app_name)))
    }
}