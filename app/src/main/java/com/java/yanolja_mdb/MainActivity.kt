package com.java.yanolja_mdb

import android.os.Bundle
import com.java.core.base.BindingActivity
import com.java.core.util.replace
import com.java.home.EmptyFragment
import com.java.home.HomeFragment
import com.java.yanolja_mdb.databinding.ActivityMainBinding

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val homeFragment: HomeFragment by lazy { HomeFragment() }
    private val emptyFragment: EmptyFragment by lazy { EmptyFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        replaceHomeFragment()
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    replaceHomeFragment()
                    return@setOnItemSelectedListener true
                }
                else -> {
                    replaceEmptyFragment()
                    return@setOnItemSelectedListener true
                }
            }
        }
    }

    private fun replaceHomeFragment() {
        replace(R.id.fragmentContainerView, homeFragment)
    }

    private fun replaceEmptyFragment() {
        replace(R.id.fragmentContainerView, emptyFragment)
    }
}
