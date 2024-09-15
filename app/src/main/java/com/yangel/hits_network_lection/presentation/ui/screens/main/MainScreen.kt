package com.yangel.hits_network_lection.presentation.ui.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.yangel.hits_network_lection.presentation.ui.component.CatCard
import com.yangel.hits_network_lection.presentation.viewmodels.MainScreenViewModel
import com.yangel.hits_network_lection.presentation.viewmodels.states.MainScreenState

/**
 * @author y.yangel
 */
@Composable
internal fun MainScreen(viewModel: MainScreenViewModel) {

    val state = viewModel.state.collectAsStateWithLifecycle()

    when (state.value) {
        MainScreenState.Initial -> viewModel.getCats()
        MainScreenState.Loading -> LoadingScreen()
        is MainScreenState.Content -> {
            val cats = (state.value as MainScreenState.Content).cats
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                cats.forEach { element ->
                    item {
                        CatCard(
                            model = element.imageUrl,
                            fact = element.facts,
                        )
                    }
                }
            }
        }
    }


}


@Composable
internal fun LoadingScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(modifier = Modifier.size(256.dp))
    }
}
