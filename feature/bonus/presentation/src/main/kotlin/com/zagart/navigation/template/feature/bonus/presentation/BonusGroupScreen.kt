package com.zagart.navigation.template.feature.bonus.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zagart.navigation.template.feature.bonus.ui.segment.BonusGroupActions
import com.zagart.navigation.template.feature.bonus.ui.segment.BonusGroupScreenUi
import com.zagart.navigation.template.presentation.navigation.destinations.BonusGroupDestination

@Composable
fun BonusGroupScreen(
    tabIndex: Int,
    destination: BonusGroupDestination,
    modifier: Modifier = Modifier,
    viewModel: BonusGroupViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val actions = remember(viewModel) {
        BonusGroupActions(
            onProductClick = { viewModel.onProductClick(it, tabIndex) },
            onBottomBarItemClick = viewModel::onBottomBarItemClick
        )
    }

    LaunchedEffect(tabIndex, destination) {
        viewModel.load(destination.id)
    }

    BonusGroupScreenUi(
        modifier = modifier,
        tabIndex = tabIndex,
        state = state,
        actions = actions
    )
}