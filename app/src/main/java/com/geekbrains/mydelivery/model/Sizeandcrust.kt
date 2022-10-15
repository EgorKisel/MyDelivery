package com.geekbrains.mydelivery.model


import com.google.gson.annotations.SerializedName

data class Sizeandcrust(
    @SerializedName("mediumPan")
    val mediumPan: List<MediumPan>,
    @SerializedName("medium stuffed crust kebab")
    val mediumStuffedCrustKebab: List<MediumStuffedCrustKebab>,
    @SerializedName("medium stuffed crust-veg kebab")
    val mediumStuffedCrustVegKebab: List<MediumStuffedCrustVegKebab>,
    @SerializedName("mediumstuffedcrustcheesemax")
    val mediumstuffedcrustcheesemax: List<Mediumstuffedcrustcheesemax>,
    @SerializedName("mediumstuffedcrustchickenseekhkebab")
    val mediumstuffedcrustchickenseekhkebab: List<Mediumstuffedcrustchickenseekhkebab>,
    @SerializedName("mediumstuffedcrustvegkebab")
    val mediumstuffedcrustvegkebab: List<MediumstuffedcrustvegkebabX>
)