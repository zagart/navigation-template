package com.zagart.navigation.template.feature.bonus.ui.segment

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zagart.navigation.template.feature.product.ui.components.ProductHorizontalCard
import com.zagart.navigation.template.ui.ExampleBottomBar
import com.zagart.navigation.template.ui.ExampleScaffold
import com.zagart.navigation.template.ui.ExampleTopBar

@Composable
fun BonusGroupScreenUi(
    state: BonusGroupScreenState,
    modifier: Modifier = Modifier,
    actions: BonusGroupActions = BonusGroupActions(),
) {
    ExampleScaffold(
        modifier = modifier,
        topBar = {
            if (state.showTopBar) {
                ExampleTopBar(state.bonusGroup.title)
            }
        },
        content = { padding ->
            LazyColumn(
                modifier = Modifier.padding(padding),
                contentPadding = PaddingValues(horizontal = 8.dp)
            ) {
                item { Spacer(modifier = Modifier.size(8.dp)) }
                items(state.products) { product ->
                    ProductHorizontalCard(
                        viewData = product,
                        onClick = actions.onProductClick
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                }
            }
        },
        bottomBar = {
            if (state.showBottomBar) {
                ExampleBottomBar(
                    selectedItemIndex = state.currentTab.ordinal,
                    onItemClicked = actions.onBottomBarItemClick,
                )
            }
        }
    )
}