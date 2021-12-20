package com.example.arraylistactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.arraylistactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var names = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            addNewName()
        }
        binding.btnGet.setOnClickListener {
            getSpecificName()
        }
    }

    private fun getSpecificName() {
        val num = binding.etNumber.text.toString()
        binding.etNumber.text.clear()
        if (checkNumber(num)) {
            val index = num.toInt() - 1
            if (index in 0 until names.size) {
                val name = names[index]
                binding.tvName.text = name
            } else {
                Toast.makeText(this, "Not exist!", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Enter Number only!", Toast.LENGTH_LONG).show()
        }
    }

    private fun addNewName() {
        val name = binding.etName.text.toString()
        binding.etName.text.clear()
        names.add(name)
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
}