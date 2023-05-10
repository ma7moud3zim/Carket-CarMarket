package com.carket.carket

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.carket.carket.*

class carAdapter(private val carArrayList : ArrayList<Car>):
    RecyclerView.Adapter<carAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.car_item_card_view , parent , false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: carAdapter.ViewHolder, position: Int) {
        val currentCar = carArrayList[position]
        holder.curCarModel.text = currentCar.title+" "+currentCar.model
        holder.curCarPrice.text = currentCar.price
        // Todo: show the image using Glide or any other method
    }

    override fun getItemCount(): Int {
        return carArrayList.size
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        // TODO:  show the things of the car on the cardView
        var curCarModel :TextView = itemView.findViewById(R.id.carModel)
        val curCarPrice :TextView = itemView.findViewById(R.id.carPrice)

        // val curCarImage : Image = itemView.findViewById(R.id.carImage)
    }

}
