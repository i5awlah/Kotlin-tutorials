package com.example.imageviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.imageviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOn.setOnClickListener {
            binding.imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.light_on))
        }
        binding.btnOff.setOnClickListener {
            binding.imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.light_off))
        }
    }
}