package com.geekbrains.mydelivery.model.retrofit

import com.geekbrains.mydelivery.model.MenuDTOItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitServices {

    @GET("pizzas")
    fun getMenuList(@Query("api_key") apiKey: String): Call<MutableList<MenuDTOItem>>
}