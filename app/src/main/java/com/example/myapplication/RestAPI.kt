package com.example.myapplication

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RestAPI {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://randomuser.me/api/")
        .addConverterFactory(GsonConverterFactory.create())
        //You need to tell Retrofit that you want to use RxJava 3
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    private fun <T> create(clazz: Class<T>): T {
        return retrofit.create(clazz)
    }

    fun userService():UserService {
        return create(UserService::class.java)
    }
}