package com.example.alertdialog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.alertdialog.databinding.ActivityMainBinding
import com.example.alertdialog.databinding.CustomDialogBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShow.setOnClickListener {
            showAlert()
        }
    }

    private fun showAlert() {
        val dialogView = layoutInflater.inflate(R.layout.custom_dialog, null)
        val binding = CustomDialogBinding.bind(dialogView)
        binding.btnTV.setOnClickListener {
            binding.tvMain.text = binding.etMain.text
        }
        binding.btnGo.setOnClickListener {
            startActivity(
                Intent(this, SecondActivity::class.java)
                    .putExtra("myText", binding.etMain.text.toString() )
            )
        }

        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setView(dialogView)
        dialogBuilder.show()
    }

}