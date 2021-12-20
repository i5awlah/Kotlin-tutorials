package com.example.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.activitylifecycle.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        Log.d("Main","onStart")
        binding.tvState.text = binding.tvState.text.toString() + "\nOnline"
    }
    override fun onStop() {
        super.onStop()
        Log.d("Main","onStop")
        val date = Date()
        binding.tvState.text = binding.tvState.text.toString() + "\n$date"
    }
}