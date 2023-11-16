package com.healthcare.presentation.ui.base

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.snackbar.Snackbar
import com.healthcare.presentation.R

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {
    abstract val layoutId: Int
    private lateinit var _binding: T
    val binding: T
        get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, layoutId)
        initState()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.unbind()
    }

    abstract fun initView()
    abstract fun subscribe()
    abstract fun initEvent()
    open fun initState() {
        initView()
        initEvent()
        subscribe()
    }

    fun isPermissionGranted(perm: String): Boolean {
        return ActivityCompat.checkSelfPermission(this, perm) == PackageManager.PERMISSION_GRANTED
    }

    fun showSnackBar(msg: String, actionMsg: String = getString(R.string.close)) {
        Snackbar.make(binding.root, msg, Snackbar.LENGTH_SHORT).also { snackbar ->
            snackbar.setAction(
                actionMsg
            ) { snackbar.dismiss() }
        }.show()
    }
}