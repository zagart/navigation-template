package com.zagart.navigation.template.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zagart.navigation.template.feature.home.ui.HomeScreenActions
import com.zagart.navigation.template.feature.home.ui.HomeScreenUi
import com.zagart.navigation.template.presentation.navigation.Tab

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val actions = remember(viewModel) {
        HomeScreenActions(
            onBottomBarItemClick = viewModel::onBottomBarItemClick,
            onProductClick = { viewData -> viewModel.onProductClick(viewData, Tab.HOME.ordinal) },
            onBonusGroupClick = { viewData -> viewModel.onBonusGroupClick(viewData, Tab.HOME.ordinal) }
        )
    }

    BackHandler(onBack = viewModel::onBackClick)
    HomeScreenUi(
        modifier = modifier,
        state = state,
        actions = actions,
        tabIndex = Tab.HOME.ordinal,
    )
}