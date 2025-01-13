package com.kachiro.game_catalog.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kachiro.game_catalog.dto.Filters
import com.kachiro.game_catalog.repository.Repository
import com.kachiro.game_detail_api.GameDetailMediator
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException

class CatalogViewModel constructor(
    private val repository: Repository,
    private val gameDetailMediator: GameDetailMediator
): ViewModel() {

    private val _stateList = MutableLiveData<ResultState>()
    val stateList: LiveData<ResultState> = _stateList

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        if (exception is SocketTimeoutException) {
            _stateList.value = ResultState.ErrorRes(com.kachiro.uikit.R.string.error_server)
        } else {
            _stateList.value = ResultState.Error(exception.localizedMessage)
        }
    }

    init {
        viewModelScope.launch(exceptionHandler) {
            val list = repository.getGames().orEmpty()
            _stateList.value = ResultState.Success(list)
        }
    }


    private val _filters = MutableLiveData<List<Filters>?>(null)
    val filters: LiveData<List<Filters>?> = _filters

    fun openDetail(id: Int) {
        gameDetailMediator.openScreenDetailGame(id)
    }

    fun applyFilter(genres: List<Filters>) {
        viewModelScope.launch(exceptionHandler) {
            _filters.value = genres.ifEmpty { null }
            _stateList.value = ResultState.Success(repository.getGamesByFilters(genres.map { it.codeFilters }))
        }
    }


}