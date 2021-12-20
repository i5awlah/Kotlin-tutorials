package com.example.multipleactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.multipleactivities.databinding.ActivityConfirmBinding
import com.example.multipleactivities.databinding.ConfirmDialogBinding

class ConfirmActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfirmBinding
    lateinit var name: String
    lateinit var location: String
    lateinit var phoneNumber: String
    lateinit var email: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fetchData()

        binding.btnConfirm.setOnClickListener {
            showAlert()
        }
    }

    private fun fetchData() {
        name = intent.getStringExtra("name")!!
        location = intent.getStringExtra("location")!!
        phoneNumber = intent.getStringExtra("phoneNumber")!!
        email = intent.getStringExtra("email")!!

        binding.tvName.text = name
        binding.tvLocation.text = location
        binding.tvPhoneNumber.text = phoneNumber
        binding.tvEmail.text = email
    }

    private fun showAlert() {
        val dialogView = layoutInflater.inflate(R.layout.confirm_dialog, null)
        val confirmDialogBinding = ConfirmDialogBinding.bind(dialogView)

        confirmDialogBinding.tvName.text = name
        confirmDialogBinding.tvLocation.text = location
        confirmDialogBinding.tvPhoneNumber.text = phoneNumber
        confirmDialogBinding.tvEmail.text = email

        confirmDialogBinding.btnConfirm.setOnClickListener {
            startActivity(
                Intent(this, DataActivity::class.java)
                    .putExtra("name", name)
                    .putExtra("location", location)
                    .putExtra("phoneNumber", phoneNumber)
                    .putExtra("email", email)
            )
        }

        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setView(dialogView)
        dialogBuilder.show()
    }
}