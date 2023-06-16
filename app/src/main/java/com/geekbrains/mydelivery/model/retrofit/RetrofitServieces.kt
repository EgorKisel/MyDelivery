package com.geekbrains.mydelivery.model.retrofit

import com.geekbrains.mydelivery.MENU_API_KEY_1
import com.geekbrains.mydelivery.MENU_API_KEY_2
import com.geekbrains.mydelivery.model.MenuDTOItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface RetrofitServices {

    @GET("pizzas")
    fun getMenuList(
        @Header("X-RapidAPI-Key") token: String = MENU_API_KEY_1,
        @Header("X-RapidAPI-Host") token2: String = "pizza-and-desserts.p.rapidapi.com"
    ): Call<MutableList<MenuDTOItem>>

}