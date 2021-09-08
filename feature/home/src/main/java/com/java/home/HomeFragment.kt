package com.java.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.java.core.base.BindingFragment
import com.java.core.util.stringListFrom
import com.java.home.adapter.HomeViewPagerAdapter
import com.java.home.databinding.FragmentHomeBinding
import com.java.home.recommand.RecommendFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        initHomeViewPager()
        return binding.root
    }

    private fun initHomeViewPager() {
        binding.apply {
            val homeViewPagerAdapter = HomeViewPagerAdapter(requireActivity())

            with(homeViewPagerAdapter) {
                fragmentList = listOf(
                    RecommendFragment(),
                    EmptyFragment(),
                    EmptyFragment(),
                    EmptyFragment(),
                    EmptyFragment()
                )
                vpMain.adapter = homeViewPagerAdapter
            }

            TabLayoutMediator(tlCategory, vpMain) { tab, position ->
                tab.text = stringListFrom(R.array.tab_text)[position]
            }.attach()
        }
    }
}
