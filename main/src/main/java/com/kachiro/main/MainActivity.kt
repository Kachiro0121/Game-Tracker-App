package com.kachiro.main

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.kachiro.core_api.di.AppWithApplicationComponent
import com.kachiro.main.databinding.ActivityMainBinding
import com.kachiro.main.di.MainComponent
import com.kachiro.main.viewmodel.MainViewModel
import com.kachiro.main.viewmodel.MainViewModelFactory
import javax.inject.Inject

class MainActivity: AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appComponent = (application as AppWithApplicationComponent).getApplicationComponentProvider()
        MainComponent.create(appComponent).inject(this)
        ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        viewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]
        viewModel.startScreen(R.id.root_container, supportFragmentManager)

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                router.exit()
            }
        })
    }

}