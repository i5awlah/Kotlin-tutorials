package com.example.buttoncounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.buttoncounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var number = 26

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvNumber.text = number.toString()

        binding.btnIncrease.setOnClickListener {
            number++
            binding.tvNumber.text = number.toString()
        }
        binding.btnDecrease.setOnClickListener {
            number--
            binding.tvNumber.text = number.toString()
        }
    }
}