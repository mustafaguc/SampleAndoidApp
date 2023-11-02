package com.example.myapplication

import io.reactivex.rxjava3.core.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface UserService {

    @GET("?results=3&gender=male&inc=email,cell,nat")
    fun randomUsers(): Observable<Data>


}