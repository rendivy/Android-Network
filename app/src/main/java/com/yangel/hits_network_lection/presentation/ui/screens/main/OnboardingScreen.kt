package com.yangel.hits_network_lection.presentation.ui.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * @author y.yangel
 */
@Composable
@Preview(showBackground = true)
internal fun OnboardingScreen(onPrimaryButtonClick: () -> Unit = {}) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = onPrimaryButtonClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
        ) {
            Text(
                text = "Получить котиков <3",
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
            )
        }
    }
}

