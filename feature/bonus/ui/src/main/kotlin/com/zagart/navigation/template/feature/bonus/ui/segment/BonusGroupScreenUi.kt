package com.zagart.navigation.template.feature.bonus.ui.segment

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zagart.navigation.template.feature.product.ui.ProductHorizontalCard
import com.zagart.navigation.template.ui.ExampleBottomBar
import com.zagart.navigation.template.ui.ExampleTopBar

@Composable
fun BonusGroupScreenUi(
    tabIndex: Int,
    state: BonusGroupScreenState,
    modifier: Modifier = Modifier,
    showBottomBar: Boolean = true,
    actions: BonusGroupActions = BonusGroupActions(),
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            ExampleTopBar(state.bonusGroup.title)
        },
        bottomBar = {
            if (showBottomBar) {
                ExampleBottomBar(
                    selectedItemIndex = tabIndex,
                    onItemClicked = actions.onBottomBarItemClick,
                )
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding),
        ) {
            items(state.products) { product ->
                ProductHorizontalCard(
                    viewData = product,
                    onClick = actions.onProductClick
                )
                Spacer(modifier = Modifier.size(8.dp))
            }
        }
    }
}