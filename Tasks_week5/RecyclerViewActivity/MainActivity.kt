package com.example.recyclerviewactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.recyclerviewactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            saveData()
        }
    }
    private fun saveData() {
        val name = binding.etName.text.toString()
        val location = binding.etLocation.text.toString()
        val phoneNumber = binding.etPhoneNumber.text.toString()
        val email = binding.etEmail.text.toString()

        if (name.isNotEmpty() && location.isNotEmpty() && phoneNumber.isNotEmpty() && email.isNotEmpty() ) {
            startActivity(
                Intent(this, DataActivity::class.java)
                    .putExtra("name", name)
                    .putExtra("location", location)
                    .putExtra("phoneNumber", phoneNumber)
                    .putExtra("email", email)
            )
        } else {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_LONG).show()
        }
    }
}