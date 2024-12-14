package com.zagart.navigation.template.feature.mylist.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.zagart.navigation.template.presentation.navigation.Tab
import com.zagart.navigation.template.ui.DummyScreen

@Composable
fun MyListScreen(
    modifier: Modifier = Modifier,
    viewModel: MyListViewModel = hiltViewModel(),
) {
    BackHandler(onBack = viewModel::onBackClick)
    DummyScreen(
        modifier = modifier,
        title = "My List",
        tabIndex = Tab.MY_LIST.ordinal,
        onNavigationItemClick = viewModel::onBottomBarItemClick,
    )
}