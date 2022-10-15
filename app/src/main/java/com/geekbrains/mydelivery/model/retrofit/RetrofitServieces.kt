package com.geekbrains.mydelivery.model.retrofit

import com.geekbrains.mydelivery.model.MenuDTOItem
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServices {

    @GET("pizzas")
    fun getMovieList(): Call<MutableList<MenuDTOItem>>
}