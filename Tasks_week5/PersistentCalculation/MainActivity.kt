package com.example.persistentcalculation


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.persistentcalculation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var result = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShow.setOnClickListener {
            val num1 = binding.etNum1.text.toString()
            val num2 = binding.etNum2.text.toString()
            if (checkNumber(num1, num2)) {
                result = num1.toDouble() * num2.toFloat()
                binding.tvResult.text = "Result = $result"
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("Result", result)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        result = savedInstanceState.getDouble("Result", 0.0)
        binding.tvResult.text = "Result = $result"
    }

    private fun checkNumber(num1: String, num2: String) : Boolean {
        return try {
            num1.toDouble()
            num2.toFloat()
            true
        } catch (e: Exception) {
            Log.d("Main", "Enter Number only!")
            false
        }
    }
}