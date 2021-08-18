package com.java.home.recommand

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.java.core.base.BindingFragment
import com.java.home.R
import com.java.home.databinding.FragmentTodayTopBinding

class TodayTopFragment : BindingFragment<FragmentTodayTopBinding>(R.layout.fragment_today_top) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        return binding.root
    }
}
