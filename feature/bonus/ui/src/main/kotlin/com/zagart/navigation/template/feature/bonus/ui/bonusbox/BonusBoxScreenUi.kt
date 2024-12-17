package com.zagart.navigation.template.feature.bonus.ui.bonusbox

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zagart.navigation.template.feature.bonus.ui.components.BonusLanesContent
import com.zagart.navigation.template.ui.ExampleBottomBar
import com.zagart.navigation.template.ui.ExampleTopBar

@Composable
fun BonusBoxScreenUi(
    state: BonusBoxScreenState,
    modifier: Modifier = Modifier,
    listState: LazyListState = rememberLazyListState(),
    actions: BonusBoxScreenActions = BonusBoxScreenActions(),
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            if (state.showTopBar) {
                ExampleTopBar(
                    title = state.title,
                    onBack = actions.onBack,
                )
            }
        },
        content = { padding ->
            BonusLanesContent(
                modifier = Modifier.padding(padding),
                actions = actions.bonusLanesActions,
                listState = listState,
                lanes = state.lanes,
            )
        },
        bottomBar = {
            if (state.showBottomBar) {
                ExampleBottomBar(
                    selectedItemIndex = state.currentTab.ordinal,
                    onItemClicked = actions.onBottomBarItemClick
                )
            }
        }
    )
}