package com.geekbrains.mydelivery.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MenuList(
    val id: Int,
    val name: String,
    val description: String,
    val image: String
) : Parcelable

@Parcelize
data class Food(
    val foodName: String = "Цыпленок карри",
    val foodIngredients: String = "Цыпленок, ананасы, сосус карри, красный лук"
) :
    Parcelable