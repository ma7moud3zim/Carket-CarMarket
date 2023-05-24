package com.carket.carket


import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.carket.carket.customer.HomeActivityCust
import kotlinx.android.synthetic.main.activity_car_view.*
import org.w3c.dom.Text


class CarView : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_view)

        val cur: Car? = intent.getParcelableExtra("carObject" )
        showData(cur)
    }


    // Get the data from the list of the current car
    private fun showData(cur:Car?){
        val curImage:ImageView = findViewById(R.id.img_item)
        Glide.with(this).load(cur!!.imageid).into(curImage)

        val carTitle: TextView = findViewById(R.id.car_title)
        carTitle.text = cur.title
        val carPrice: TextView = findViewById(R.id.car_price)
        carPrice.text = cur.price
        val carDetails: TextView = findViewById(R.id.car_details_text)
        carDetails.text = "Car model: "+cur.model +"\n" +
                          "Year of made: "+cur.year+"\n"+
                          "Countr of made: "+cur.country+"\n"+
                          "Price of the car: "+cur.price+"\n";


    }

}