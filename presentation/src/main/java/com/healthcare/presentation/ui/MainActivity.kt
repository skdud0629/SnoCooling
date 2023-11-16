package com.healthcare.presentation.ui

import com.healthcare.presentation.R
import com.healthcare.presentation.databinding.ActivityMainBinding
import com.healthcare.presentation.ui.analysis.AnalysisFragment
import com.healthcare.presentation.ui.base.BaseActivity
import com.healthcare.presentation.ui.tracking.TrackingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val layoutId: Int
        get() = R.layout.activity_main

    override fun initView() {
        val fm = supportFragmentManager
        fm.beginTransaction().add(R.id.main_fragment_container, TrackingFragment()).commit()
    }

    override fun subscribe() {

    }

    override fun initEvent() {
        binding.bottomNavigation.setOnItemSelectedListener {
            val fm = supportFragmentManager
            when(it.itemId) {
                R.id.navigation_item_home -> {
                    fm.beginTransaction()
                        .replace(R.id.main_fragment_container, TrackingFragment())
                        .commit()
                    true
                }
                R.id.navigation_item_analysis -> {
                    fm.beginTransaction()
                        .replace(R.id.main_fragment_container, AnalysisFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}