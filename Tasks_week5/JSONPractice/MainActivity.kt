package com.example.jsonpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.jsonpractice.databinding.ActivityMainBinding
import com.example.jsonpractice.models.Contact
import com.example.jsonpractice.services.APIClient
import com.example.jsonpractice.services.APIInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnGet.setOnClickListener {
                val number = etNumber.text.toString()
                etNumber.text.clear()

                if (checkNumber(number)) {
                    fetchData(number.toInt())
                }
            }
        }
    }

    private fun checkNumber(num: String) : Boolean {
        return try {
            num.toInt()
            true
        } catch (e: Exception) {
            Log.d("Main", "Error: $e")
            false
        }
    }

    private fun fetchData(id: Int) {
        APIClient.getClient()?.create(APIInterface::class.java)?.getPerson()?.enqueue(object: Callback<Contact>{
            override fun onResponse(call: Call<Contact>, response: Response<Contact>) {
                val contacts = response.body()!!

                val index = id-1
                if (index in 0 until contacts.size) {
                    val name = response.body()!![index].name
                    binding.tvName.text = name
                }
            }

            override fun onFailure(call: Call<Contact>, t: Throwable) {
                Log.d("Main", "Unable to get data")
            }

        })
    }
}