package es.iessaladillo.pedrojoya.intents.data.local.model

import androidx.annotation.DrawableRes


data class Pokemon(val id:Long ,
                   val name:String,
                   @DrawableRes
                   val imageResId:Int,
                   val power:Int,
)