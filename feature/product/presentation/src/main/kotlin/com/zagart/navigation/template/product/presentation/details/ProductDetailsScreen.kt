package com.zagart.navigation.template.product.presentation.details

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zagart.navigation.template.feature.product.ui.details.ProductDetailsScreenActions
import com.zagart.navigation.template.feature.product.ui.details.ProductDetailsScreenUi
import com.zagart.navigation.template.presentation.navigation.ProductDetailsDestination
import com.zagart.navigation.template.ui.Tab

@Composable
fun ProductDetailsScreen(
    destination: ProductDetailsDestination,
    modifier: Modifier = Modifier,
    viewModel: ProductDetailsViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val actions = remember(viewModel) {
        ProductDetailsScreenActions(
            onBottomBarItemClick = viewModel::onBottomBarItemClick
        )
    }

    LaunchedEffect(destination) {
        viewModel.load(destination)
    }

    BackHandler(onBack = viewModel::onBackClick)
    ProductDetailsScreenUi(
        state = state,
        modifier = modifier,
        actions = actions,
    )
}