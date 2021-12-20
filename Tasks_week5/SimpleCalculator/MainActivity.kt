package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.simplecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            performOperation("+")
        }

        binding.btnSubtract.setOnClickListener {
            performOperation("-")
        }
        binding.btnMultiply.setOnClickListener {
            performOperation("*")
        }

        binding.btnDivide.setOnClickListener {
            performOperation("/")
        }
    }

    private fun performOperation(opp: String) {
        val num1 = binding.etNum1.text.toString()
        val num2 = binding.etNum2.text.toString()
        if (checkNumber(num1, num2)) {
            val result = when (opp) {
                "+" -> num1.toDouble() + num2.toDouble()
                "-" -> num1.toDouble() - num2.toDouble()
                "*" -> num1.toDouble() * num2.toDouble()
                "/" -> {
                    if (num2.toDouble() == 0.0)
                        0.0
                    else
                        num1.toDouble() / num2.toDouble()
                }

                else -> 0.0
            }
            binding.tvResult.text = "Result: $result"
        } else {
            Toast.makeText(this, "Enter Number Only!", Toast.LENGTH_LONG).show()
        }
    }

    private fun checkNumber(num1: String, num2: String) : Boolean {
        return try {
            num1.toDouble()
            num2.toDouble()
            true
        } catch (e: Exception) {
            Log.d("Main", "Error: $e")
            false
        }
    }
}