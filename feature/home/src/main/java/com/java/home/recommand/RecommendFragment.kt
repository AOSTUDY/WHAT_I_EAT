package com.java.home.recommand

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.chip.Chip
import com.java.core.base.BindingFragment
import com.java.core.util.stringListFrom
import com.java.home.R
import com.java.home.adapter.*
import com.java.home.databinding.FragmentRecommendBinding
import com.java.home.util.ChipFactory

class RecommendFragment : BindingFragment<FragmentRecommendBinding>(R.layout.fragment_recommend) {
    private val String.toChip: Chip
        get() = ChipFactory.create(layoutInflater).also { it.text = this }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        initChip()
        initAdapter()
        return binding.root
    }

    private fun provideChipClickListener(chip: Chip) =
        View.OnClickListener {
            binding.cgChip.clearCheck()
            chip.isChecked = true
        }

    private fun initChip() {
        stringListFrom(R.array.chip_text)
            .asSequence()
            .map { it.toChip.apply { this.setOnClickListener(provideChipClickListener(this)) } }
            .forEach { binding.cgChip.addView(it) }
    }

    private fun initAdapter() {
        binding.apply {
            rvSpecial.adapter =
                BenefitAdapter().apply { data = stringListFrom(R.array.benefit_text) }
            rvRecommend.adapter =
                NewAndHotAdapter().apply { data = stringListFrom(R.array.new_and_hot_text) }
            vpAd.adapter = BannerAdapter().apply { data = stringListFrom(R.array.banner_list) }
            rvLocation.adapter = LocationAdapter().apply { data = stringListFrom(R.array.location_text) }
            rvSpecialPrice.adapter =
                TodayPriceAdapter().apply { data = stringListFrom(R.array.price_list) }
        }
    }
}
