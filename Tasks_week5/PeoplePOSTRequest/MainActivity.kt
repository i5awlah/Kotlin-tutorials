package com.example.peoplepostrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.peoplepostrequest.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    companion object {
        var TAG = "Main"
    }

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fetchAPI()

        binding.apply {
            btnAdd.setOnClickListener {
                val newName = etName.text.toString()
                etName.text.clear()

                if (newName.isNotEmpty()) {
                    addNewPerson(newName)
                }
            }
        }
    }

    private fun fetchAPI() {
        APIClient.getClient()?.create(APIInterface::class.java)?.getPeople()?.enqueue(object:
            Callback<People> {
            override fun onResponse(call: Call<People>, response: Response<People>) {
                val people = response.body()!!
                for (people in people) {
                    Log.d(TAG, "**: $people")
                }
            }

            override fun onFailure(call: Call<People>, t: Throwable) {
                Log.d(TAG, "Error: $t")
            }

        })
    }

    private fun addNewPerson(name: String) {
        val newPeople = PeopleItem(name, 0)
        APIClient.getClient()?.create(APIInterface::class.java)?.addPeople(newPeople)?.enqueue(object: Callback < PeopleItem> {
            override fun onResponse(call: Call<PeopleItem>, response: Response<PeopleItem>) {
                Log.d(TAG, "Added!")
            }

            override fun onFailure(call: Call<PeopleItem>, t: Throwable) {
                Log.d(TAG, "Error: $t")
            }

        })
    }
}