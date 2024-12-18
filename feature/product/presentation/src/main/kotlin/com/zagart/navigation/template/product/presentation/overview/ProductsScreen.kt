package com.zagart.navigation.template.product.presentation.overview

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.zagart.navigation.template.presentation.navigation.ProductsDestination
import com.zagart.navigation.template.ui.DummyScreen
import com.zagart.navigation.template.ui.Tab

@Composable
fun ProductsScreen(
    destination: ProductsDestination,
    modifier: Modifier = Modifier,
    viewModel: ProductsViewModel = hiltViewModel(),
) {
    LaunchedEffect(destination) {
        viewModel.load(destination)
    }

    BackHandler(onBack = viewModel::onBack)
    DummyScreen(
        modifier = modifier,
        title = "Products",
        tabIndex = Tab.PRODUCTS.ordinal,
        onNavigationItemClick = viewModel::onBottomBarItemClick,
    )
}