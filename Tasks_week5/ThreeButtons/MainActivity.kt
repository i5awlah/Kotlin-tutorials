package com.example.threebuttons

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.threebuttons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnToast.setOnClickListener {
            val text = binding.etOne.text
            Toast.makeText(this, text, Toast.LENGTH_LONG).show()
        }
        binding.btnTextView.setOnClickListener {
            val text = binding.etTwo.text
            binding.textView.text = text
        }
        binding.btnGo.setOnClickListener {
            val text = binding.etThree.text.toString()
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("myText", text)
            startActivity(intent)
        }
    }
}