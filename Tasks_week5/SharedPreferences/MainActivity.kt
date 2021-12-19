package com.example.sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            sharedPreferences = this.getSharedPreferences("Details", Context.MODE_PRIVATE)
            with(sharedPreferences.edit()) {
                putString("Name", binding.etName.text.toString())
                putInt("Age", binding.etAge.text.toString().toInt())
                apply()
            }
        }

        binding.btnShare.setOnClickListener {
            startActivity(
                Intent(this, SecondActivity::class.java)
                    .putExtra("Name", binding.etName.text.toString())
                    .putExtra("Age", binding.etAge.text.toString().toInt())
            )
        }
    }
}