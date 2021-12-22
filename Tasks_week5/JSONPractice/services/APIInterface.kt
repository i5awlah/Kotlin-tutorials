package com.example.jsonpractice.services
import com.example.jsonpractice.models.Contact
import retrofit2.Call
import retrofit2.http.*

interface APIInterface {
    @GET("contacts/")
    fun getPerson(): Call<Contact>
}