package com.geekbrains.mydelivery.model.retrofit

import com.geekbrains.mydelivery.model.MenuDTOItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface RetrofitServices {

    @GET("pizzas")
    fun getMenuList(
        @Header("X-RapidAPI-Key") token: String = "9fb3046c93msh8851f1973697936p1e60e5jsnf451c9ebd530",
        @Header("X-RapidAPI-Host") token2: String = "pizza-and-desserts.p.rapidapi.com"
    ): Call<MutableList<MenuDTOItem>>

}