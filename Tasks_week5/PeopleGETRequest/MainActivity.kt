package com.example.peoplegetrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestAPI()
    }

    private fun requestAPI() {
        CoroutineScope(IO).launch {
            val data = async { getData() }.await()
            if (data.isNotEmpty()) {
                
                // Display all the data that you receive from the API in a Text View
                    withContext(Main) {
                        val names = JSONArray(data)
                        var text = ""
                        for (i in 0 until names.length()) {
                            val name = names.getJSONObject(i).getString("name")
                            text += "\n$name"
                        }

                        binding.tvNames.text = text
                    }
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
}