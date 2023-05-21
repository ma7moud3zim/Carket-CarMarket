package com.carket.carket


import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.carket.carket.customer.HomeActivityCust


class CarView : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_view)
        // Todo("Retrieve CarData From Firebase To Display it")

        //var id = intent.getStringExtra("id")!!.toInt()
        //id=0
        //showData(id)
    }

    private fun showData(id:Int){
        val nw = HomeActivityCust()
        Toast.makeText(this, nw.carArrayList.size, Toast.LENGTH_SHORT).show()
        //val car = nw.carArrayList[id]
        val curImage:ImageView = findViewById(R.id.carImage)
        //Glide.with(this).load(car.imageid).into(curImage)
    }

}