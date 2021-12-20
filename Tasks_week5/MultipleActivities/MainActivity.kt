package com.example.multipleactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.multipleactivities.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener {
            signUp()
        }
    }

    private fun signUp() {
        val name = binding.etName.text.toString()
        val location = binding.etLocation.text.toString()
        val phoneNumber = binding.etPhoneNumber.text.toString()
        val email = binding.etEmail.text.toString()
        val agree = binding.checkBox.isChecked

        if (name.isNotEmpty() && location.isNotEmpty() && phoneNumber.isNotEmpty() && email.isNotEmpty() ) {
            if (agree) {
                startActivity(
                    Intent(this, ConfirmActivity::class.java)
                        .putExtra("name", name)
                        .putExtra("location", location)
                        .putExtra("phoneNumber", phoneNumber)
                        .putExtra("email", email)
                )
            } else {
                // show alert
                Toast.makeText(this, "Please approve", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_LONG).show()
        }
    }
}