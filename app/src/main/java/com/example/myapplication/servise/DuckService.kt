package com.example.myapplication.servise

import com.example.myapplication.model.Duck
import retrofit2.Call
import retrofit2.http.GET

interface DuckService {
    @GET("api/v2/random")
    fun getDuck(): Call<Duck>
}