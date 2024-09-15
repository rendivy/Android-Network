package com.yangel.hits_network_lection.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yangel.hits_network_lection.domain.usecases.GetCatsUseCase
import com.yangel.hits_network_lection.presentation.viewmodels.states.MainScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * @author y.yangel
 */
class MainScreenViewModel(private val getCatsUseCase: GetCatsUseCase) : ViewModel() {

    private val _state = MutableStateFlow<MainScreenState>(MainScreenState.Initial)
    val state: StateFlow<MainScreenState> = _state.asStateFlow()

    fun getCats() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = MainScreenState.Loading
            val cats = getCatsUseCase()
            _state.value = MainScreenState.Content(cats)
        }
    }

}
