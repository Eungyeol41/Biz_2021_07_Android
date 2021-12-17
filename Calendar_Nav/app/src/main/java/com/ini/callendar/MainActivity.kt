package com.ini.callendar

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation

import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.ini.callendar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                // R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )

        if(actionBar != null) {
            actionBar?.setLogo(R.drawable.logo_3)
            actionBar?.setDisplayHomeAsUpEnabled(true)
            actionBar?.setDisplayUseLogoEnabled(true)
            actionBar?.setDisplayShowHomeEnabled(true)
        }

//        actionBar?.setLogo(R.drawable.logo_3)

        // setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_nav_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val setting_item:Int = item.itemId
        if(setting_item == R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item);
    }
}