package com.example.multipleactivities

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.multipleactivities.databinding.ActivityDataBinding

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
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.A -> {
                showAlert()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showAlert(){
        val dialogBuilder = AlertDialog.Builder(this)

        dialogBuilder.setPositiveButton("Home", DialogInterface.OnClickListener {
                    dialog, id -> startActivity(Intent(this, ConfirmActivity::class.java))
            })

            .setNegativeButton("Exit", DialogInterface.OnClickListener {
                    dialog, id -> this.finishAffinity()
            })
        val alert = dialogBuilder.create()
        alert.setTitle("Where do you want to go?")
        alert.show()
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