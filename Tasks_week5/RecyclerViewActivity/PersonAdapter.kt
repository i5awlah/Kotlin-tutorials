package com.example.recyclerviewactivity

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewactivity.databinding.PersonRowBinding

class PersonAdapter(private var persons: ArrayList<Person>): RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    class PersonViewHolder(val binding: PersonRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(
            PersonRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)
        )
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = persons[position]
        holder.binding.apply {
            tvName.text = person.name
            tvLocation.text = person.location
            tvPhoneNumber.text = person.phoneNumber
            tvEmail.text = person.email
        }
    }

    override fun getItemCount() = persons.size

    fun update(persons: ArrayList<Person>) {
        this.persons = persons
        notifyDataSetChanged()
    }
}