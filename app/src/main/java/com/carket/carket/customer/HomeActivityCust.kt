package com.carket.carket.customer

import android.os.Bundle
import android.view.MenuItem
import android.widget.AbsListView.RecyclerListener
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.carket.carket.BaseActivity
import com.carket.carket.Car
import com.carket.carket.R
import com.carket.carket.carAdapter
import com.google.android.material.navigation.NavigationView
import com.google.firebase.database.*

class HomeActivityCust : BaseActivity() {
    private lateinit var toggle : ActionBarDrawerToggle
    private lateinit var database : DatabaseReference
    private lateinit var carRV : RecyclerView
    private lateinit var carArrayList:ArrayList<Car>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_cust)
        carRV = findViewById(R.id.carRV)
        carRV.layoutManager = LinearLayoutManager(this)
        carRV.setHasFixedSize(true)


        carArrayList = arrayListOf<Car>()
        getCars()

        val drawerLayout : DrawerLayout = findViewById(R.id.homeCustomer)
        val navView : NavigationView = findViewById(R.id.navCust)

        toggle = ActionBarDrawerToggle(this, drawerLayout,R.string.open , R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        // This is fake stuff for the navigationBar
        navView.setNavigationItemSelectedListener{
            when(it.itemId){
                R.id.profileCust -> Toast.makeText(this, "profile clicked", Toast.LENGTH_SHORT).show()
                R.id.favrCust -> Toast.makeText(this, "favourite clicked", Toast.LENGTH_SHORT).show()
                R.id.logout -> Toast.makeText(this, "logout clicked", Toast.LENGTH_SHORT).show()
            }

            true
        }
    }

    // This function that gets the cars from Firebase
    private fun getCars(){
        database = FirebaseDatabase.getInstance().getReference("Cars")

        database.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                carArrayList.clear()
                if(snapshot.exists()){
                    for(carSnap in snapshot.children) {
                        val curCar = carSnap.getValue(Car::class.java)
                        carArrayList.add(curCar!!)
                    }
                    val mAdapater = carAdapter(this@HomeActivityCust, carArrayList)
                    carRV.adapter = mAdapater
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return true
    }

}