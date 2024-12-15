package com.zagart.navigation.template.feature.bonus.ui.bonusbox

import androidx.compose.foundation.layout.padding
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
    actions: BonusBoxScreenActions = BonusBoxScreenActions(),
) {
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
                actions = actions.bonusLanesActions,
                lanes = state.lanes
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