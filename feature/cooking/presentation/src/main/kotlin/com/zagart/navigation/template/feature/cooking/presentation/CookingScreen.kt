package com.zagart.navigation.template.feature.cooking.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.zagart.navigation.template.presentation.navigation.Tab
import com.zagart.navigation.template.ui.DummyScreen

@Composable
fun CookingScreen(
    modifier: Modifier = Modifier,
    viewModel: CookingViewModel = hiltViewModel(),
) {
    DummyScreen(
        modifier = modifier,
        title = "Cooking",
        tabIndex = Tab.COOKING.ordinal,
        onBonusGroupClick = viewModel::onBonusGroupClick,
        onNavigationItemClick = viewModel::onTabItemClick,
    )
}