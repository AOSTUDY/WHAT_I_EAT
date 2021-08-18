package com.java.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.java.home.R
import com.java.home.databinding.ItemRecommendBinding

class BenefitAdapter() : RecyclerView.Adapter<BenefitAdapter.BenefitViewHolder>() {
    private val _data = mutableListOf<String>()
    var data: List<String> = _data
        set(value) {
            _data.clear()
            _data.addAll(value)
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = _data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BenefitViewHolder {
        val binding: ItemRecommendBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_recommend, parent, false
        )

        return BenefitViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BenefitViewHolder, position: Int) {
        holder.bind(_data[position])
    }

    class BenefitViewHolder(private val binding: ItemRecommendBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String) {
            binding.tvTitle.text = data
        }
    }
}
