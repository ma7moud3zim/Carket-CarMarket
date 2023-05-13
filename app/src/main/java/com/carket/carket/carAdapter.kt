package com.carket.carket

import android.content.Context
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.carket.carket.*

class carAdapter(private val ctx: Context, private val carArrayList : ArrayList<Car>):
    RecyclerView.Adapter<carAdapter.ViewHolder>(){

    var listner: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.car_item_card_view , parent , false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: carAdapter.ViewHolder, position: Int) {
        val currentCar = carArrayList[position]
        holder.curCarModel.text = currentCar.title+" "+currentCar.model+"$"
        holder.curCarPrice.text = currentCar.price
        // Todo: show the image using Glide or any other method
        // using glide to display the image in RecyclerView
        Glide.with(ctx).load(carArrayList[position].imageid).into(holder.curCarImage)

        holder.itemView.rootView.setOnClickListener {
            listner!!.onClicked(carArrayList[position].car_id)
        }

    }

    override fun getItemCount(): Int {
        return carArrayList.size
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        // TODO:  show the things of the car on the cardView
        var curCarModel :TextView = itemView.findViewById(R.id.carModel)
        val curCarPrice :TextView = itemView.findViewById(R.id.carPrice)
        val curCarImage : ImageView = itemView.findViewById(R.id.carImage)
    }
    public fun setClickListner(listen:OnItemClickListener){
        listner = listen
    }
    interface OnItemClickListener{
        fun onClicked(carTitle :String?)
    }

}
