package com.geekbrains.mydelivery.model


import com.google.gson.annotations.SerializedName

data class MediumPan(
    @SerializedName("price")
    val price: Int
)