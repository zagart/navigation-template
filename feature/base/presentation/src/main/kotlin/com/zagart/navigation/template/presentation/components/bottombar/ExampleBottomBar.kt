package com.zagart.navigation.template.presentation.components.bottombar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zagart.navigation.template.presentation.navigation.NavigationViewModel
import com.zagart.navigation.template.presentation.navigation.isApplication
import com.zagart.navigation.template.ui.ExampleBottomBarUi
import com.zagart.navigation.template.ui.Tab

@Composable
fun ExampleBottomBar(
    modifier: Modifier = Modifier,
    viewModel: ExampleBottomBarViewModel = hiltViewModel(),
) {
    val currentDestination by NavigationViewModel
        .currentDestinationState
        .collectAsStateWithLifecycle()

    if (currentDestination?.args?.bottomBarScope.isApplication()) {
        ExampleBottomBarUi(
            modifier = modifier,
            selectedItemIndex = currentDestination?.args?.backstackIndex ?: Tab.HOME.ordinal,
            onItemClicked = viewModel::onBottomBarItemClick
        )
    }
}