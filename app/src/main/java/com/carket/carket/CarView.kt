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

        val cur: Car? = intent.getParcelableExtra("carObject" )
        //id=0
        showData(cur)
    }

    private fun showData(cur:Car?){
        Toast.makeText(this, "I am here", Toast.LENGTH_SHORT).show()
        //val car = nw.carArrayList[id]
        val curImage:ImageView = findViewById(R.id.img_item)
        Glide.with(this).load(cur!!.imageid).into(curImage)
    }

}