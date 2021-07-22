package com.example.android.navigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout : DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val navCon = this.findNavController(R.id.NavHost)
        drawerLayout=binding.drawerLayout
        NavigationUI.setupActionBarWithNavController(this,navCon,drawerLayout)
        NavigationUI.setupWithNavController(binding.navView,navCon)
        navCon.addOnDestinationChangedListener{nc: NavController, nd: NavDestination, args: Bundle ?->
            if(nd.id==nc.graph.startDestination)
            {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            }
            else
            {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navCon = this.findNavController(R.id.NavHost)
        return NavigationUI.navigateUp(navCon,drawerLayout)
    }
}
