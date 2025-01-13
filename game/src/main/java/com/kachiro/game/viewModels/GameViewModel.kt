package com.kachiro.game.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kachiro.game.repository.GameRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException

class GameViewModel(
    private val repository: GameRepository
): ViewModel() {

    companion object{

        private val listPlatform = listOf("pc", "browser")

    }


    private val _stateList = MutableLiveData<ResultGames>()
    val stateList: LiveData<ResultGames> = _stateList

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        if (exception is SocketTimeoutException) {
            _stateList.value = ResultGames.ErrorRes(com.kachiro.uikit.R.string.error_server)
        } else {
            _stateList.value = ResultGames.Error(exception.localizedMessage)
        }
    }

    fun onInit() {
        viewModelScope.launch(exceptionHandler) {
            val listCategory = repository.getGamesByCategory(listPlatform)
            _stateList.value = ResultGames.Success(listCategory)
        }
    }

}