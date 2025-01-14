package com.kachiro.home

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.kachiro.base.BaseFragment
import com.kachiro.core_api.di.AppWithApplicationComponent
import com.kachiro.home.databinding.HomeScreenBinding
import com.kachiro.home.di.HomeComponent
import com.kachiro.home.help.AnimatedFragmentNavigator
import com.kachiro.home.viewmodel.HomeViewModel
import javax.inject.Inject

class HomeFragment: BaseFragment<HomeScreenBinding>() {

    private val navigator by lazy { AnimatedFragmentNavigator(requireActivity(), R.id.home_container, childFragmentManager) }

    override fun getViewBinding(): HomeScreenBinding = HomeScreenBinding.inflate(layoutInflater)

    private lateinit var viewModel: HomeViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    companion object{
        private const val ID_SELECT_NAVIGATION = "ID_SELECT_NAVIGATION"
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
            sharedPreferences.edit().putInt(ID_SELECT_NAVIGATION, item.itemId).apply()
            when (item.itemId) {
                R.id.navigation_home -> viewModel.gameScreen()
                R.id.navigation_catalog -> viewModel.catalogScreen()
                else -> Unit
            }
            true
        }

        binding.mainNavigationView.selectedItemId = sharedPreferences.getInt(ID_SELECT_NAVIGATION, R.id.navigation_home)
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