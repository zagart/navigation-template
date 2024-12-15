package com.zagart.navigation.template.feature.bonus.ui.overview

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zagart.navigation.template.feature.bonus.ui.components.BonusLanesContent
import com.zagart.navigation.template.ui.ExampleBottomBar
import com.zagart.navigation.template.ui.ExampleTopBar

@Composable
fun BonusScreenUi(
    state: BonusScreenState,
    modifier: Modifier = Modifier,
    actions: BonusScreenActions = BonusScreenActions(),
    backstackIndex: Int = 1,
) {
    val listState = rememberLazyListState()
    Scaffold(
        modifier = modifier,
        topBar = {
            if (state.showTopBar) {
                ExampleTopBar(title = state.title)
            }
        },
        content = { padding ->
            BonusLanesContent(
                modifier = Modifier.padding(padding),
                listState = listState,
                lanes = state.lanes,
                actions = actions.bonusLanesActions
            )
        },
        bottomBar = {
            if (state.showBottomBar) {
                ExampleBottomBar(
                    selectedItemIndex = backstackIndex,
                    onItemClicked = actions.onBottomBarItemClick
                )
            }
        },
    )
}