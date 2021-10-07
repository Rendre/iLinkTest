package com.example.myapplication.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppClient {
    private val map: HashMap<String, Retrofit> = HashMap()

    fun call(url: String): Retrofit{
        var client = map.getOrDefault(url, null)
        if (client == null){
            client = Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build()
        }
        return client!!
    }

}