package com.example.simplebuttonlistener

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.simplebuttonlistener.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnKotlin.setOnClickListener {
            Toast.makeText(this, "Coding", Toast.LENGTH_LONG).show()
        }

    }
    fun showToast(view: View) {
        Toast.makeText(this, "XML", Toast.LENGTH_LONG).show()
    }
}