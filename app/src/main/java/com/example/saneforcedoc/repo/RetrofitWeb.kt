package com.example.saneforcedoc.repo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitWeb {


    private const val BASE_URL = "http://mapi.san.one/api/"

    val api: Apis by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Apis::class.java)
    }
}