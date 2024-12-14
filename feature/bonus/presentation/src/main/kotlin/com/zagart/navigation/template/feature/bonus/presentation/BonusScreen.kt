package com.zagart.navigation.template.feature.bonus.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.zagart.navigation.template.presentation.navigation.Tab
import com.zagart.navigation.template.ui.DummyScreen

@Composable
fun BonusScreen(
    modifier: Modifier = Modifier,
    viewModel: BonusViewModel = hiltViewModel(),
) {
    BackHandler(onBack = viewModel::onBackClick)
    DummyScreen(
        modifier = modifier,
        title = "Bonus",
        tabIndex = Tab.BONUS.ordinal,
        onNavigationItemClick = viewModel::onBottomBarItemClick,
    )
}