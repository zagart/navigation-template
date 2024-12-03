package com.zagart.navigation.example.features.home.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zagart.navigation.example.features.home.ui.HomeScreenUi
import com.zagart.navigation.example.shared.presentation.Tab

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    HomeScreenUi(
        state = state,
        modifier = modifier,
        onNavigationItemClick = viewModel::onNavigationItemClick,
        onProductClick = { viewModel.onProductClick(it, Tab.HOME.ordinal) }
    )
}