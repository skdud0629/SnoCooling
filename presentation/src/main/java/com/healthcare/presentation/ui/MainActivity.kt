package com.healthcare.presentation.ui

import android.Manifest
import android.os.Build
import androidx.fragment.app.Fragment
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
        requestRequiredPermissions()
        initBottomNavigationEvent()
    }

    private fun initBottomNavigationEvent() {
        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.navigation_item_home -> {
                    replaceFragment(TrackingFragment())
                    true
                }
                R.id.navigation_item_analysis -> {
                    replaceFragment(AnalysisFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun requestRequiredPermissions() {
        val permissions = arrayListOf(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.RECORD_AUDIO
        )

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            permissions.add(Manifest.permission.READ_MEDIA_AUDIO)
            permissions.add(Manifest.permission.POST_NOTIFICATIONS)
        }
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
        requestPermissions(permissions.toTypedArray(), 0)
    }

    private fun replaceFragment(fragment: Fragment) {
        val fm = supportFragmentManager
        fm.beginTransaction().replace(R.id.main_fragment_container, fragment).commit()
    }
}