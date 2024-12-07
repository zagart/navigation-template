package com.zagart.navigation.template.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zagart.navigation.template.feature.home.ui.HomeScreenUi
import com.zagart.navigation.template.presentation.navigation.Tab

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    HomeScreenUi(
        state = state,
        modifier = modifier,
        bottomNavigationIndex = Tab.HOME.ordinal,
        onNavigationItemClick = viewModel::onTabItemClick,
        onProductClick = { viewModel.onProductClick(it.id, Tab.HOME.ordinal) }
    )
}