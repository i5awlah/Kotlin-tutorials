package com.example.getandpostlocation.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
    companion object {
        private var retrofit: Retrofit? = null

        fun getClient(): Retrofit? {
            retrofit = Retrofit.Builder()
                .baseUrl("https://dojo-recipes.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit
        }
    }
}