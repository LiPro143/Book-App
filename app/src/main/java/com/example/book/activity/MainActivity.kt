package com.example.book.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.book.R
import com.example.book.fragment.AboutAppFragment
import com.example.book.fragment.DashboardFragment
import com.example.book.fragment.FavouriteFragment
import com.example.book.fragment.ProfileFragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout:  DrawerLayout
    lateinit var coordinator: CoordinatorLayout
    lateinit var toolbar: Toolbar
    lateinit var frame: FrameLayout
    lateinit var navigation: NavigationView

    var previousMenuItem: MenuItem? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        drawerLayout = findViewById(R.id.drawerLayout)
        coordinator = findViewById(R.id.coordinator)
        toolbar = findViewById(R.id.toolbar)
        frame = findViewById(R.id.frame)
        navigation = findViewById(R.id.navigation)
        setUpToobar()

        openDashboard()

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this@MainActivity, drawerLayout, R.string.open_drawer, R.string.close_drawer
        )

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigation.setNavigationItemSelectedListener {

            if (previousMenuItem != null){
                previousMenuItem?.isChecked = false
            }
            it.isCheckable = true
            it.isChecked = true
            previousMenuItem = it

            when (it.itemId) {
                R.id.Dashboard -> {
                  openDashboard()
                  drawerLayout.closeDrawers()
                }
                R.id.Favourite -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame, FavouriteFragment())
                        .addToBackStack("Favourite")
                        .commit()

                    drawerLayout.closeDrawers()
                }
                R.id.Profile -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame, ProfileFragment())
                        .addToBackStack("Profile")
                        .commit()

                    drawerLayout.closeDrawers()
                }
                R.id.AboutApp -> {
                    supportFragmentManager.beginTransaction().replace(R.id.frame, AboutAppFragment())
                        .addToBackStack("About App")
                        .commit()

                    drawerLayout.closeDrawers()
                }
            }

            return@setNavigationItemSelectedListener true

        }
    }


    fun setUpToobar () {
        setSupportActionBar(toolbar)
        supportActionBar?.title="Books"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = item.itemId
        if (id == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return super.onOptionsItemSelected(item)
    }

    fun openDashboard(){
        val fragment = DashboardFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame, fragment)
        transaction.commit()
        supportActionBar?.title = "Dashboard"
        navigation.setCheckedItem(R.id.Dashboard)
    }

    override fun onBackPressed() {
        val frag = supportFragmentManager.findFragmentById(R.id.frame)
        when(frag){
            !is DashboardFragment -> openDashboard()
            else -> super.onBackPressed()
        }

    }
}