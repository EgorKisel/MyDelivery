package com.geekbrains.mydelivery.data.repoimpl

import com.geekbrains.mydelivery.common.BASE_URL
import com.geekbrains.mydelivery.data.model.MenuDTO
import com.geekbrains.mydelivery.data.service.RetrofitServices
import com.geekbrains.mydelivery.domain.RepositoryMenu
import com.geekbrains.mydelivery.presentation.menu.ViewModelMenu
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryMenuImpl: RepositoryMenu {

    private val api = Retrofit.Builder().apply {
        baseUrl(BASE_URL)
        addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
    }.build().create(RetrofitServices::class.java)

    override fun getAllMenu(callbackMy: ViewModelMenu.Callback) {
        api.getMenuList().enqueue(object : Callback<MenuDTO> {
            override fun onResponse(call: Call<MenuDTO>, response: Response<MenuDTO>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        callbackMy.onResponse(it)
                    }
                }
            }
            override fun onFailure(call: Call<MenuDTO>, t: Throwable) {
                //Not yet implemented
            }
        })
    }
}