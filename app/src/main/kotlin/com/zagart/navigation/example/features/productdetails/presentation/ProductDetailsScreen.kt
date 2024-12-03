package com.zagart.navigation.example.features.productdetails.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.zagart.navigation.example.shared.ui.DummyScreen

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
        onNavigationItemClick = viewModel::onNavigationItemClick,
    )
}