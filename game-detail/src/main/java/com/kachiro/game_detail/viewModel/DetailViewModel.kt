package com.kachiro.game_detail.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kachiro.game_detail.dto.GameDetail
import com.kachiro.game_detail.repository.DetailRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: DetailRepository
): ViewModel() {

    companion object{
        private const val TAG = "DetailViewModel"
    }

    private val _detail: MutableLiveData<GameDetail> = MutableLiveData()
    val detail: LiveData<GameDetail> = _detail

    fun setGame(id: Int){
        viewModelScope.launch {
            try {
                _detail.value = repository.gameDetail(id)
            } catch (e: Exception) {
                Log.d(TAG, "setGame: ${e.message}")
            }
        }
    }

}