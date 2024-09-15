package com.yangel.hits_network_lection.presentation.viewmodels.states

import com.yangel.hits_network_lection.domain.entity.Cat

/**
 * @author y.yangel
 */
sealed class MainScreenState {
    data object Initial : MainScreenState()

    data object Loading : MainScreenState()

    data class Content(val cats: List<Cat>) : MainScreenState()
}
