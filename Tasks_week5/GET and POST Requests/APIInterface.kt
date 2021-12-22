package com.example.peoplepostrequest

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface APIInterface {
    @GET("custom-people/")
    fun getPeople() : Call<People>

    @POST("custom-people/")
    fun addPeople(@Body people: PeopleItem) : Call<PeopleItem>
}