package com.java.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.java.data.model.LocalButtonData
import com.java.home.R
import com.java.home.databinding.ItemRecommendBinding

class BenefitAdapter : RecyclerView.Adapter<BenefitAdapter.BenefitViewHolder>() {
    private val _data = mutableListOf<LocalButtonData>()
    var data: List<LocalButtonData> = _data
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
        fun bind(data: LocalButtonData) {
            with(binding) {
                data.apply {
                    tvTitle.text = name
                    ivIcon.setImageResource(image)
                }
            }
        }
    }
}
