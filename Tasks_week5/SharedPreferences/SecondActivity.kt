package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferences.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvName.text = intent.getStringExtra("Name")
        binding.tvAge.text = intent.extras?.get("Age").toString()

        binding.btnShow.setOnClickListener {
            sharedPreferences = this.getSharedPreferences("Details", Context.MODE_PRIVATE)
            val name = sharedPreferences.getString("Name", "")
            val age = sharedPreferences.getInt("Age", 0)

            binding.tvName.text = name
            binding.tvAge.text = age.toString()
        }
    }
}