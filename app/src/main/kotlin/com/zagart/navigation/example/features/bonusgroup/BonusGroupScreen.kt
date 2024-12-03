package com.zagart.navigation.example.features.bonusgroup

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.zagart.navigation.example.shared.ui.DummyScreen

@Composable
fun BonusGroupScreen(
    tabIndex: Int,
    modifier: Modifier = Modifier,
    viewModel: BonusGroupViewModel = hiltViewModel(),
) {
    DummyScreen(
        modifier = modifier,
        title = "Bonus Group",
        tabIndex = tabIndex,
        onBonusGroupClick = { _, _ -> },
        onNavigationItemClick = viewModel::onNavigationItemClick,
    )
}