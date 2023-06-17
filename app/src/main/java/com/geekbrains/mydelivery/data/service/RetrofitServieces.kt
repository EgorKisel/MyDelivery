package com.geekbrains.mydelivery.data.service

import com.geekbrains.mydelivery.common.MENU_API_KEY_2
import com.geekbrains.mydelivery.common.MENU_HOST
import com.geekbrains.mydelivery.data.model.MenuDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface RetrofitServices {

    @GET("pizzas")
    fun getMenuList(
        @Header("X-RapidAPI-Key") token: String = MENU_API_KEY_2,
        @Header("X-RapidAPI-Host") token2: String = MENU_HOST
    ): Call<MenuDTO>
}