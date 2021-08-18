package com.java.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.java.home.R
import com.java.home.databinding.ItemBannerBinding

class BannerAdapter() : RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {
    private val _data = mutableListOf<String>()
    var data: List<String> = _data
        set(value) {
            _data.clear()
            _data.addAll(value)
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = _data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val binding: ItemBannerBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_banner, parent, false
        )

        return BannerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bind(_data[position])
    }

    class BannerViewHolder(private val binding: ItemBannerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String) {
            Glide.with(binding.ivBanner).load(data).into(binding.ivBanner)
        }
    }
}
