package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // In the onCreate method, practice Kotlin basics
        // printing to the console
        var msg = "Hello, I am Khawlah"
        Log.d("MainActivity", msg)

        // using if statements
        val year: Int = Calendar.getInstance().get(Calendar.YEAR);

        if (year ==  2021) {
            Log.d("MainActivity","Its 2021 :)")
        }
        
        // performing basic calculations
        val x = 10
        val y = 20
        val result = sum(x,y)
        Log.d("MainActivity", "$x + $y = $result")

    }
    //Add some custom functions and call them within the onCreate method
    private fun sum(num1: Int, num2: Int): Int {
        return num1 + num2
    }
}