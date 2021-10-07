package com.example.myapplication

import com.example.myapplication.retrofit.AppClient
import com.example.myapplication.servise.CatService

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.example.myapplication.model.Cat
import com.example.myapplication.model.Duck
import com.example.myapplication.servise.DuckService
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getCat(view: View){
        val catService: CatService = AppClient.call("https://thatcopy.pw").create(CatService::class.java)
        val cat = catService.getCat()
        val imageView = findViewById<ImageView>(R.id.imageView)
        cat.enqueue(object: Callback<Cat>{
            override fun onResponse(callCat: Call<Cat>, responseCat: Response<Cat>){
                if (responseCat.isSuccessful){
                    val url = responseCat.body()!!.url
                    Picasso.get().load(url).resize(800, 600).into(imageView)
                }
            }

            override fun onFailure(call: Call<Cat>, t: Throwable) {

            }
        })
    }

    fun getDuck(view: View){
        val duckService: DuckService = AppClient.call("https://random-d.uk").create(DuckService::class.java)
        val duck = duckService.getDuck()
        val imageView = findViewById<ImageView>(R.id.imageView)
        duck.enqueue(object: Callback<Duck>{
            override fun onResponse(callDuck: Call<Duck>, responseDuck: Response<Duck>) {
                if (responseDuck.isSuccessful){
                    val url = responseDuck.body()!!.url
                    Picasso.get().load(url).resize(800,600).into(imageView)
                }
            }

            override fun onFailure(call: Call<Duck>, t: Throwable) {

            }
        })
    }

}