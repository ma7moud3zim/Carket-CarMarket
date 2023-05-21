package com.carket.carket

import java.io.Serializable

data class Car(val car_id:String? =null , val company:String? =null ,val country:String? =null
               ,val imageid:String? =null ,val model:String? =null ,val price:String? =null
               , val title:String?=null ,val year:String? = null ) : Serializable {

               }
