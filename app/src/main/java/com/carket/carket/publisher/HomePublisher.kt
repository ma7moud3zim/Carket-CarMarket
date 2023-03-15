package com.carket.carket.publisher

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.carket.carket.BaseActivity
import com.carket.carket.R
import com.google.android.material.navigation.NavigationView

class HomePublisher:BaseActivity() {
    lateinit var toggle : ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_pub)

        val drawerLayout: DrawerLayout = findViewById(R.id.homepublisher)
        val navView: NavigationView = findViewById(R.id.navigation)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {

                R.id.profilepub -> Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT)
                    .show()
                R.id.favrpub -> Toast.makeText(this, "Favourite clicked", Toast.LENGTH_SHORT).show()
                R.id.setpub -> Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show()
                R.id.logoutpub -> Toast.makeText(this, "Logout clicked", Toast.LENGTH_SHORT).show()
            }

            true
        }

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item))
            return true
        return true
    }

}