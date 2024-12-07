package com.zagart.navigation.template.product.presentation.details

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.zagart.navigation.template.ui.DummyScreen

@Composable
fun ProductDetailsScreen(
    backstackIndex: Int,
    modifier: Modifier = Modifier,
    viewModel: ProductDetailsViewModel = hiltViewModel(),
) {
    DummyScreen(
        modifier = modifier,
        title = "Product details",
        tabIndex = backstackIndex,
        onBonusGroupClick = viewModel::onBonusGroupClick,
        onNavigationItemClick = viewModel::onTabItemClick,
    )
}