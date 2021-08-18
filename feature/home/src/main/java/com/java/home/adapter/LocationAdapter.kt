package com.java.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.java.home.R
import com.java.home.databinding.ItemLocationBinding

class LocationAdapter() : RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {
    private val _data = mutableListOf<String>()
    var data: List<String> = _data
        set(value) {
            _data.clear()
            _data.addAll(value)
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = _data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val binding: ItemLocationBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_location, parent, false
        )

        return LocationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.bind(_data[position])
    }

    class LocationViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String) {
            binding.tvLocation.text = data
            Glide.with(binding.ivLocation)
                .load("https://i.insider.com/58525b95dd0895b7548b4b08?width=700").circleCrop()
                .into(binding.ivLocation)
        }
    }
}
