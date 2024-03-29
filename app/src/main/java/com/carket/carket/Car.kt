package com.carket.carket

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Car(val car_id:String? =null , val company:String? =null ,val country:String? =null
               ,val imageid:String? =null ,val model:String? =null ,val price:String? =null
               , val title:String?=null ,val year:String? = null ) : Parcelable
