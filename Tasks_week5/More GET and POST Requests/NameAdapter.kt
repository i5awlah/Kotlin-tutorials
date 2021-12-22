package com.example.getandpostlocation


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.getandpostlocation.databinding.RowNameBinding

class NameAdapter(private val names: ArrayList<String>): RecyclerView.Adapter<NameAdapter.NameViewHolder>() {
    class NameViewHolder(val binding: RowNameBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        return NameViewHolder(RowNameBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        val name = names[position]
        holder.binding.apply {
            tvName.text = name
        }
    }

    override fun getItemCount() = names.size
}