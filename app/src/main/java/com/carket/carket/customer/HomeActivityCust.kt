package com.carket.carket.customer

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.carket.carket.BaseActivity
import com.carket.carket.R
import com.google.android.material.navigation.NavigationView

class HomeActivityCust : BaseActivity() {
    private lateinit var toggle : ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_cust)

        val drawerLayout : DrawerLayout = findViewById(R.id.homeCustomer)
        val navView : NavigationView = findViewById(R.id.navCust)

        toggle = ActionBarDrawerToggle(this, drawerLayout,R.string.open , R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener{
            when(it.itemId){

                R.id.profileCust -> Toast.makeText(this, "profile clicked", Toast.LENGTH_SHORT).show()
                R.id.favrCust -> Toast.makeText(this, "favourite clicked", Toast.LENGTH_SHORT).show()
                R.id.logout -> Toast.makeText(this, "logout clicked", Toast.LENGTH_SHORT).show()
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