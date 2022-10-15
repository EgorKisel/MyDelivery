package com.geekbrains.mydelivery.model.common

import com.geekbrains.mydelivery.model.retrofit.RetrofitClient
import com.geekbrains.mydelivery.model.retrofit.RetrofitServices

object Common {

    private val BASE_URL = "https://pizza-and-desserts.p.rapidapi.com/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}