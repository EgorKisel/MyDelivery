package com.geekbrains.mydelivery.model


import com.google.gson.annotations.SerializedName

data class MenuDTOItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("img")
    val img: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("sizeandcrust")
    val sizeandcrust: List<Sizeandcrust>,
    @SerializedName("veg")
    val veg: Boolean
)