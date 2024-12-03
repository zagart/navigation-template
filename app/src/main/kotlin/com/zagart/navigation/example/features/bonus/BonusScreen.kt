package com.zagart.navigation.example.features.bonus

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.zagart.navigation.example.shared.presentation.Tab
import com.zagart.navigation.example.shared.ui.DummyScreen

@Composable
fun BonusScreen(
    modifier: Modifier = Modifier,
    viewModel: BonusViewModel = hiltViewModel(),
) {
    DummyScreen(
        modifier = modifier,
        title = "Bonus",
        tabIndex = Tab.BONUS.ordinal,
        onBonusGroupClick = viewModel::onBonusGroupClick,
        onNavigationItemClick = viewModel::onNavigationItemClick,
    )
}