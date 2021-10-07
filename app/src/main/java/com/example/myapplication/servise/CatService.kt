package com.example.myapplication.servise

import com.example.myapplication.model.Cat
import retrofit2.Call
import retrofit2.http.GET


interface CatService {
    @GET("catapi/rest")
    fun getCat(): Call<Cat>
}