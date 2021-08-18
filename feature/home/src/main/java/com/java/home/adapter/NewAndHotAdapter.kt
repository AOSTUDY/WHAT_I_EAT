package com.java.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.java.home.R
import com.java.home.databinding.ItemNewAndHotBinding

class NewAndHotAdapter() : RecyclerView.Adapter<NewAndHotAdapter.NewAndHotViewHolder>() {
    private val _data = mutableListOf<String>()
    var data: List<String> = _data
        set(value) {
            _data.clear()
            _data.addAll(value)
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = _data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewAndHotViewHolder {
        val binding: ItemNewAndHotBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_new_and_hot, parent, false
        )

        return NewAndHotViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewAndHotViewHolder, position: Int) {
        holder.bind(_data[position])
    }

    class NewAndHotViewHolder(private val binding: ItemNewAndHotBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String) {
            binding.tvTitle.text = data
        }
    }
}
