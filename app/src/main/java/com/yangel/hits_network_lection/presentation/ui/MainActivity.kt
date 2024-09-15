package com.yangel.hits_network_lection.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yangel.hits_network_lection.MyApplication
import com.yangel.hits_network_lection.presentation.ui.component.CatCard
import com.yangel.hits_network_lection.presentation.ui.screens.main.MainScreen
import com.yangel.hits_network_lection.presentation.ui.screens.main.OnboardingScreen
import com.yangel.hits_network_lection.presentation.ui.theme.HitsnetworklectionTheme
import com.yangel.hits_network_lection.presentation.viewmodels.MainScreenViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val appContainer = (application as MyApplication).appContainer
        val viewModel = MainScreenViewModel(appContainer.useCase)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            HitsnetworklectionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    NavHost(
                        navController = navController,
                        startDestination = "onboarding",
                        modifier = Modifier.padding(it)
                    ) {
                        composable("onboarding") {
                            OnboardingScreen(onPrimaryButtonClick = { navController.navigate("main") })
                        }
                        composable("main") {
                            MainScreen(viewModel = viewModel)
                        }
                    }
                }
            }
        }
    }
}
