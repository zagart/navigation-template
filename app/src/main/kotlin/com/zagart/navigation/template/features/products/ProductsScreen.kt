package com.zagart.navigation.template.features.products

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.zagart.navigation.template.shared.presentation.Tab
import com.zagart.navigation.template.shared.ui.DummyScreen

@Composable
fun ProductsScreen(
    modifier: Modifier = Modifier,
    viewModel: ProductsViewModel = hiltViewModel(),
) {
    DummyScreen(
        modifier = modifier,
        title = "Products",
        tabIndex = Tab.PRODUCTS.ordinal,
        onBonusGroupClick = viewModel::onBonusGroupClick,
        onNavigationItemClick = viewModel::onNavigationItemClick,
    )
}