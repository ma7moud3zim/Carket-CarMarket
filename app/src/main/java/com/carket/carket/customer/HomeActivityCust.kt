package com.carket.carket.customer

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.carket.carket.*
import com.carket.carket.R
import com.google.android.material.navigation.NavigationView
import com.google.firebase.database.*

class HomeActivityCust : BaseActivity() {
    private lateinit var toggle : ActionBarDrawerToggle
    private lateinit var database : DatabaseReference
    private lateinit var carRV : RecyclerView
    lateinit var carArrayList:ArrayList<Car>
    private lateinit var carAdp : carAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_cust)
        carRV = findViewById(R.id.carRV)
        carRV.layoutManager = LinearLayoutManager(this)
        carRV.setHasFixedSize(true)
        getCars()

        carArrayList = arrayListOf()
        carAdp = carAdapter(this@HomeActivityCust,carArrayList)
        carAdp.setClickListner(onClicked)


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
    override fun onResume() {
        super.onResume()
        carRV.adapter = carAdp
    }


    private val onClicked = object : carAdapter.OnItemClickListener{
        override fun onClicked(pos: Int?) {
            val intent = Intent(this@HomeActivityCust, CarView::class.java)
            intent.putExtra("carObject",carArrayList[pos!!])
            startActivity(intent)
        }
    }
    // To go to CarView of clicked card

    
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

                }
                carRV.setHasFixedSize(true);
                carRV.layoutManager = LinearLayoutManager(this@HomeActivityCust)
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