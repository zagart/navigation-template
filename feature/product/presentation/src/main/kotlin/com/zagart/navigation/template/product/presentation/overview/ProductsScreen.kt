package com.zagart.navigation.template.product.presentation.overview

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.zagart.navigation.template.ui.Tab
import com.zagart.navigation.template.ui.DummyScreen

@Composable
fun ProductsScreen(
    modifier: Modifier = Modifier,
    viewModel: ProductsViewModel = hiltViewModel(),
) {
    BackHandler(onBack = viewModel::onBack)
    DummyScreen(
        modifier = modifier,
        title = "Products",
        tabIndex = Tab.PRODUCTS.ordinal,
        onNavigationItemClick = viewModel::onBottomBarItemClick,
    )
}