package com.example.getandpostlocation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.getandpostlocation.databinding.ActivityMainBinding
import com.example.getandpostlocation.models.Person
import com.example.getandpostlocation.models.PersonItem
import com.example.getandpostlocation.services.APIClient
import com.example.getandpostlocation.services.APIInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var person = arrayListOf<PersonItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getAllPerson()

        binding.apply {
            btnSave.setOnClickListener {
                val name = etName.text.toString()
                val location = etLocation.text.toString()

                etName.text.clear()
                etLocation.text.clear()

                if (name.isNotEmpty() && location.isNotEmpty()) {
                    addNewPerson(name, location)
                } else {
                    Log.d("Main", "Empty!")
                }
            }

            btnGet.setOnClickListener {
                val name = etNameSearch.text.toString()
                etNameSearch.text.clear()

                if (name.isNotEmpty()) {
                    for (person in person) {
                        if (person.name == name) {
                            getPerson(person.pk)
                        }
                    }
                } else {
                    Log.d("Main", "Empty!")
                }
            }

        }
    }

    private fun getAllPerson() {
        APIClient.getClient()?.create(APIInterface::class.java)?.getPerson()?.enqueue( object:
            Callback<Person>{
            override fun onResponse(call: Call<Person>, response: Response<Person>) {
                val data = response.body()!!

                for (i in 0 until data.size) {
                    person.add(data[i])
                }

            }

            override fun onFailure(call: Call<Person>, t: Throwable) {
                Log.d("Main", "Unable to get data!")
            }

        })
    }

    private fun getPerson(id: Int) {
        APIClient.getClient()?.create(APIInterface::class.java)?.getPerson(id)?.enqueue( object:
            Callback<PersonItem>{
            override fun onResponse(call: Call<PersonItem>, response: Response<PersonItem>) {
                val data = response.body()!!
                binding.tvLocation.text = data.location
            }

            override fun onFailure(call: Call<PersonItem>, t: Throwable) {
                Log.d("Main", "Unable to get data!")
            }

        })
    }

    private fun addNewPerson(name: String, location: String) {
        val newPerson = PersonItem(location, name, 0)
        APIClient.getClient()?.create(APIInterface::class.java)?.addPerson(newPerson)?.enqueue(object:
            Callback<PersonItem>{
            override fun onResponse(call: Call<PersonItem>, response: Response<PersonItem>) {
                Log.d("Main", "Added!")
            }

            override fun onFailure(call: Call<PersonItem>, t: Throwable) {
                Log.d("Main", "Unable to Add!")
            }

        })

    }
}