package com.zagart.navigation.template.feature.bonus.ui.overview

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.zagart.navigation.template.feature.bonus.ui.components.BonusLanesContent
import com.zagart.navigation.template.ui.ExampleScaffold
import com.zagart.navigation.template.ui.ExampleTopBarUi

@Composable
fun BonusScreenUi(
    state: BonusScreenState,
    modifier: Modifier = Modifier,
    actions: BonusScreenActions = BonusScreenActions(),
) {
    val listState = rememberLazyListState()
    ExampleScaffold(
        modifier = modifier,
        topBar = {
            if (state.showTopBar) {
                ExampleTopBarUi(title = state.title)
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
    )
}