package com.zagart.navigation.example.features.mylist

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.zagart.navigation.example.shared.presentation.Tab
import com.zagart.navigation.example.shared.ui.DummyScreen

@Composable
fun MyListScreen(
    modifier: Modifier = Modifier,
    viewModel: MyListViewModel = hiltViewModel(),
) {
    DummyScreen(
        modifier = modifier,
        title = "My List",
        tabIndex = Tab.MY_LIST.ordinal,
        onBonusGroupClick = viewModel::onBonusGroupClick,
        onNavigationItemClick = viewModel::onNavigationItemClick,
    )
}