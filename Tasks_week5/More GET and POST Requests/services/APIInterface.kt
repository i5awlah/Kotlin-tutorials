package com.example.getandpostlocation.services

import com.example.getandpostlocation.models.Person
import com.example.getandpostlocation.models.PersonItem
import retrofit2.Call
import retrofit2.http.*

interface APIInterface {

    @GET("test/")
    fun getPerson(): Call<Person>

    @GET("test/{id}")
    fun getPerson(@Path("id") id: Int): Call<PersonItem>

    @POST("test/")
    fun addPerson(@Body person: PersonItem): Call<PersonItem>
}