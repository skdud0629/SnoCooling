package com.healthcare.presentation.ui.tracking

import android.content.Intent
import android.os.Build
import androidx.fragment.app.viewModels
import com.healthcare.presentation.R
import com.healthcare.presentation.databinding.FragmentTrackingBinding
import com.healthcare.presentation.service.TrackingService
import com.healthcare.presentation.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrackingFragment : BaseFragment<FragmentTrackingBinding>() {
    override val layoutId: Int
        get() = R.layout.fragment_tracking

    private val trackingIntent by lazy {
        Intent(requireContext(), TrackingService::class.java)
    }

    override fun initView() {

    }

    override fun initEvent() {
        binding.buttonStartTracking.setOnClickListener {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                requireContext().startForegroundService(trackingIntent)
            else
                requireContext().startService(trackingIntent)
        }
    }

    override fun subscribe() {

    }
}