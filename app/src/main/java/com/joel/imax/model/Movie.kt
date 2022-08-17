package com.joel.imax.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val id : Int,
    val name : String,
    val year : String,
    val imageUrl : Int,
    val genre : String,
    val rating : String,
    val description : String,
//    val time : String,
) : Parcelable
