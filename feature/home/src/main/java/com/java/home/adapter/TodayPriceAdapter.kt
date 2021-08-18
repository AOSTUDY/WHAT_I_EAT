package com.java.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.java.home.R
import com.java.home.databinding.ItemNewAndHotBinding
import com.java.home.databinding.ItemTodayPriceBinding

class TodayPriceAdapter() : RecyclerView.Adapter<TodayPriceAdapter.TodayPriceViewHolder>() {
    private val _data = mutableListOf<String>()
    var data: List<String> = _data
        set(value) {
            _data.clear()
            _data.addAll(value)
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = _data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayPriceViewHolder {
        val binding: ItemTodayPriceBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_today_price, parent, false
        )

        return TodayPriceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodayPriceViewHolder, position: Int) {
        holder.bind(_data[position])
    }

    class TodayPriceViewHolder(private val binding: ItemTodayPriceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String) {
            Glide.with(binding.ivBanner).load(data).into(binding.ivBanner)
        }
    }
}
