package com.geekbrains.mydelivery.model


import com.google.gson.annotations.SerializedName

data class MenuDTOItem(
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("img")
    val img: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("price")
    val price: Int? = null,
    @SerializedName("quantity")
    val quantity: Int? = null,
    @SerializedName("sizeandcrust")
    val sizeandcrust: List<Sizeandcrust>? = null,
    @SerializedName("veg")
    val veg: Boolean? = null
)