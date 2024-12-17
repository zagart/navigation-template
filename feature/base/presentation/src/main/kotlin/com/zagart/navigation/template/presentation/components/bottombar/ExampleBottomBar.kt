package com.zagart.navigation.template.presentation.components.bottombar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.zagart.navigation.template.ui.ExampleBottomBarUi

@Composable
fun ExampleBottomBar(
    selectedItemIndex: Int,
    modifier: Modifier = Modifier,
    viewModel: ExampleBottomBarViewModel = hiltViewModel(),
) {
    ExampleBottomBarUi(
        modifier = modifier,
        selectedItemIndex = selectedItemIndex,
        onItemClicked = viewModel::onBottomBarItemClick
    )
}