package com.kachiro.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kachiro.home_api.HomeMediator
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    private val homeMediator: HomeMediator
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(homeMediator) as T
    }
}