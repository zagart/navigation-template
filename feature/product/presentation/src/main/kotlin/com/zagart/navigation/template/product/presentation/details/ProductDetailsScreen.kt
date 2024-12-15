package com.zagart.navigation.template.product.presentation.details

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zagart.navigation.template.feature.product.ui.details.ProductDetailsScreenActions
import com.zagart.navigation.template.feature.product.ui.details.ProductDetailsScreenUi
import com.zagart.navigation.template.presentation.navigation.Destination
import com.zagart.navigation.template.presentation.navigation.ProductDetailsDestination

@Composable
fun ProductDetailsScreen(
    destination: ProductDetailsDestination,
    modifier: Modifier = Modifier,
    viewModel: ProductDetailsViewModel = hiltViewModel(),
    background: @Composable (() -> Unit)? = null,
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

    when (destination.args.type) {
        is Destination.Type.Fullscreen ->
            ProductDetailsScreenUi(
                state = state,
                modifier = modifier,
                actions = actions,
            )

        is Destination.Type.Dialog -> Dialog(
            onDismissRequest = viewModel::onBackClick
        ) {
            if (background != null) {
                background()
            }
            ProductDetailsScreenUi(
                modifier = modifier.size(400.dp),
                state = state,
                actions = actions,
            )
        }

        is Destination.Type.BottomSheet -> Box(
            modifier = modifier
                .background(Color.Gray.copy(alpha = 0.8f))
                .fillMaxSize()
        ) {
            if (background != null) {
                background()
            }
            ProductDetailsScreenUi(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .height(400.dp),
                state = state,
                actions = actions,
            )
        }
    }
}