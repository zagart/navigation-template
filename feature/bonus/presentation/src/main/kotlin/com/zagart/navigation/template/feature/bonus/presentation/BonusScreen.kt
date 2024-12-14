package com.zagart.navigation.template.feature.bonus.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zagart.navigation.template.feature.bonus.ui.overview.BonusScreenActions
import com.zagart.navigation.template.feature.bonus.ui.overview.BonusScreenUi
import com.zagart.navigation.template.presentation.navigation.Tab

@Composable
fun BonusScreen(
    modifier: Modifier = Modifier,
    viewModel: BonusViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val actions = remember(viewModel) {
        BonusScreenActions(
            onBottomBarItemClick = viewModel::onBottomBarItemClick,
            onProductClick = { viewData -> viewModel.onProductClick(viewData, Tab.BONUS.ordinal) },
            onBonusGroupClick = { viewData -> viewModel.onBonusGroupClick(viewData, Tab.BONUS.ordinal) }
        )
    }

    BackHandler(onBack = viewModel::onBackClick)
    BonusScreenUi(
        state = state,
        modifier = modifier,
        actions = actions,
        backstackIndex = Tab.BONUS.ordinal
    )
}