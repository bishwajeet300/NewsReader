package com.bishwajeet.newsreader.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.bishwajeet.newsreader.R
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val host: NavHostFragment =
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
                        ?: return
        val navController = host.navController
        val drawerLayout: DrawerLayout? = findViewById(R.id.drawer_layout)

        appBarConfiguration = AppBarConfiguration(
                setOf(R.id.newsFeedFragment, R.id.newsReaderFragment, R.id.aboutFragment),
                drawerLayout
        )

        setupActionBar(navController, appBarConfiguration)
        setupNavigationMenu(navController)
    }


    private fun setupNavigationMenu(navController: NavController) {
        val sideNavView = findViewById<NavigationView>(R.id.nav_view)
        sideNavView?.setupWithNavController(navController)
    }


    private fun setupActionBar(navController: NavController, appBarConfig: AppBarConfiguration) {
        setupActionBarWithNavController(navController, appBarConfig)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController(R.id.nav_host_fragment)) || super.onOptionsItemSelected(
                item
        )
    }


    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration)
    }
}
