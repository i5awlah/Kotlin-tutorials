package com.example.getandpostlocation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

    lateinit var rvNames: RecyclerView
    lateinit var adapter: NameAdapter
    lateinit var names: ArrayList<String>

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
                getAllPerson()
            }

        }
    }

    private fun setupRV() {
        rvNames = binding.rvNames
        adapter = NameAdapter(names)
        rvNames.adapter = adapter
        rvNames.layoutManager = LinearLayoutManager(this)
    }

    private fun getAllPerson() {
        APIClient.getClient()?.create(APIInterface::class.java)?.getPerson()?.enqueue( object:
            Callback<Person>{
            override fun onResponse(call: Call<Person>, response: Response<Person>) {
                val data = response.body()!!

                names = arrayListOf()
                for (i in 0 until data.size) {
                    names.add(data[i].name)
                }

                setupRV()
            }

            override fun onFailure(call: Call<Person>, t: Throwable) {
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