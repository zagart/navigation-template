package com.zagart.navigation.example.features.cooking

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.zagart.navigation.example.shared.presentation.Tab
import com.zagart.navigation.example.shared.ui.DummyScreen

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
        onNavigationItemClick = viewModel::onNavigationItemClick,
    )
}