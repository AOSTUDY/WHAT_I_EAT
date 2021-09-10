package com.java.home.recommand

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.google.android.material.chip.Chip
import com.java.core.base.BindingFragment
import com.java.core.util.stringListFrom
import com.java.home.HomeViewModel
import com.java.home.R
import com.java.home.adapter.BannerAdapter
import com.java.home.adapter.BenefitAdapter
import com.java.home.adapter.LocationAdapter
import com.java.home.adapter.NewAndHotAdapter
import com.java.home.adapter.TodayPriceAdapter
import com.java.home.databinding.FragmentRecommendBinding
import com.java.home.util.ChipFactory
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecommendFragment : BindingFragment<FragmentRecommendBinding>(R.layout.fragment_recommend) {
    private val String.toChip: Chip
        get() = ChipFactory.create(layoutInflater).also { it.text = this }
    private val viewModel by activityViewModels<HomeViewModel>()
    private val benefitAdapter = BenefitAdapter()
    private val newAndHotAdapter = NewAndHotAdapter()
    private val locationAdapter = LocationAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        observeData()
        initData()
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
            rvSpecial.adapter = benefitAdapter
            rvRecommend.adapter = newAndHotAdapter
            vpAd.adapter = BannerAdapter().apply { data = stringListFrom(R.array.banner_list) }
            rvLocation.adapter = locationAdapter
            rvSpecialPrice.adapter =
                TodayPriceAdapter().apply { data = stringListFrom(R.array.price_list) }
        }
    }

    private fun observeData() {
        viewModel.apply {
            benefit.observe(viewLifecycleOwner) {
                benefitAdapter.data = it
            }

            newAndHot.observe(viewLifecycleOwner) {
                newAndHotAdapter.data = it
            }

            trip.observe(viewLifecycleOwner) {
                locationAdapter.data = it
            }
        }
    }

    private fun initData() {
        viewModel.apply {
            getBenefit()
            getNewAndHot()
            getTrip()
        }
    }
}
