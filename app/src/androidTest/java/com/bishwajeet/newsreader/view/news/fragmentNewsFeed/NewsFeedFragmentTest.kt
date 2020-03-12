package com.bishwajeet.newsreader.view.news.fragmentNewsFeed

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.bishwajeet.newsreader.R
import com.bishwajeet.newsreader.view.news.fragmentNewsFeed.helper.NewsFeedListItemViewHolder
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NewsFeedFragmentTest {


    @Test
    fun testNavigationToNewsReaderScreen() {

        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        navController.setGraph(R.navigation.nav_graph)

        val titleScenario = launchFragmentInContainer<NewsFeedFragment>()

        titleScenario.onFragment { fragment ->
            Navigation.setViewNavController(fragment.requireView(), navController)
        }

        Thread.sleep(5000)

        onView(ViewMatchers.withId(R.id.gvNewsFeed))
            .perform(RecyclerViewActions.scrollToPosition<NewsFeedListItemViewHolder>(20))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<NewsFeedListItemViewHolder>(
                    20,
                    ViewActions.click()
                )
            )

        Assert.assertEquals(navController.currentDestination?.id, R.id.newsReaderFragment)
    }
}