package com.kachiro.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.kachiro.core_api.di.AppWithApplicationComponent

abstract class BaseFragment<VB: ViewBinding>: Fragment() {

    protected abstract fun getViewBinding(): VB

    private var _binding: VB? = null
    protected val binding get() = _binding!!

    protected fun getAppComponent() = (requireActivity().application as AppWithApplicationComponent).getApplicationComponentProvider()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = getViewBinding()
        return _binding?.root
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}