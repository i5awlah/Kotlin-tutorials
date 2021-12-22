package com.example.peoplegetrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.peoplegetrequest.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import java.lang.Exception
import java.net.URL

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = "Main"
    }

    val url = "https://dojo-recipes.herokuapp.com/people/"

    lateinit var binding: ActivityMainBinding
    lateinit var rvNames: RecyclerView
    lateinit var adapter: NameAdapter
    lateinit var names: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestAPI()
    }

    private fun setupRV() {
        rvNames = binding.rvNames
        adapter = NameAdapter(names)
        rvNames.adapter = adapter
        rvNames.layoutManager = LinearLayoutManager(this)
    }

    private fun requestAPI() {
        CoroutineScope(IO).launch {
            val data = async { getData() }.await()
            if (data.isNotEmpty()) {
                populateRV(data)
            } else {
                Log.d(TAG, "Unable to get data")
            }
        }
    }

    private fun getData() : String {
        var response = ""
        try {
            response = URL(url).readText()
        } catch (e: Exception) {
            Log.d(TAG,"Error: $e")
        }
        return response
    }

    private suspend fun populateRV(data: String) {
        withContext(Main) {
            names = arrayListOf()
            val namesArray = JSONArray(data)

            for (i in 0 until namesArray.length()) {
                val name = namesArray.getJSONObject(i).getString("name")
                names.add(name)
            }
            
            setupRV()
        }
    }
}