package com.kachiro.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.kachiro.base.BaseFragment
import com.kachiro.core_api.di.AppWithApplicationComponent
import com.kachiro.home.databinding.HomeScreenBinding
import com.kachiro.home.di.HomeComponent
import com.kachiro.home.viewmodel.HomeViewModel
import javax.inject.Inject

class HomeFragment: BaseFragment<HomeScreenBinding>() {

    private val navigator by lazy { AppNavigator(requireActivity(), R.id.home_container, childFragmentManager) }

    override fun getViewBinding(): HomeScreenBinding = HomeScreenBinding.inflate(layoutInflater)

    private lateinit var viewModel: HomeViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    companion object{
        fun newInstance() = HomeFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        HomeComponent.create((requireActivity().application as AppWithApplicationComponent)
            .getApplicationComponentProvider())
            .inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mainNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> viewModel.gameScreen()
                R.id.navigation_dashboard -> viewModel.gameScreen()
                R.id.navigation_notifications -> viewModel.gameScreen()
                else -> false
            }
            true
        }
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

}