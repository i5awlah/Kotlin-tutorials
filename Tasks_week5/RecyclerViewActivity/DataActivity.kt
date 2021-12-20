package com.example.recyclerviewactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewactivity.databinding.ActivityDataBinding

class DataActivity : AppCompatActivity() {

    lateinit var binding: ActivityDataBinding
    lateinit var rvData: RecyclerView
    lateinit var adapter: PersonAdapter
    var persons = arrayListOf<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRV()
        addNewPerson()

        binding.btnBack.setOnClickListener {
            startActivity(
                Intent(this, MainActivity::class.java)
            )
        }

    }

    private fun setupRV() {
        rvData = binding.rvData
        adapter = PersonAdapter(persons)
        rvData.adapter = adapter
        rvData.layoutManager = LinearLayoutManager(this)
    }

    private fun addNewPerson() {
        val name = intent.getStringExtra("name")!!
        val location = intent.getStringExtra("location")!!
        val phoneNumber = intent.getStringExtra("phoneNumber")!!
        val email = intent.getStringExtra("email")!!
        val newPerson = Person(name, location, phoneNumber, email)

        persons.add(newPerson)
        adapter.update(persons)
    }
}