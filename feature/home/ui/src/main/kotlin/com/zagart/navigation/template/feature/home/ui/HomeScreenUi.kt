package com.zagart.navigation.template.feature.home.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zagart.navigation.template.feature.bonus.ui.BonusGroupCard
import com.zagart.navigation.template.feature.product.ui.ProductCard
import com.zagart.navigation.template.ui.ExampleBottomBar
import com.zagart.navigation.template.ui.ExampleTopBar

@Composable
fun HomeScreenUi(
    state: HomeState,
    modifier: Modifier = Modifier,
    actions: HomeScreenActions = HomeScreenActions(),
    tabIndex: Int = 0,
) {
    Scaffold(
        modifier = modifier,
        topBar = { ExampleTopBar("Home") },
        bottomBar = {
            ExampleBottomBar(
                selectedItemIndex = tabIndex,
                onItemClicked = actions.onNavigationItemClick,
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier.padding(padding),
        ) {
            items(state.lanes) { lane ->
                LazyRow(
                    contentPadding = PaddingValues(
                        start = 8.dp,
                        end = 8.dp,
                        top = 8.dp,
                        bottom = 0.dp,
                    ),
                ) {
                    items(lane.items) { item ->
                        Row {
                            when (item) {
                                is HomeItem.BonusGroup -> BonusGroupCard(
                                    viewData = item.viewData,
                                    onClick = actions.onBonusGroupClick
                                )
                                is HomeItem.Product -> ProductCard(
                                    viewData = item.viewData,
                                    onClick = actions.onProductClick,
                                )
                            }
                            Spacer(Modifier.size(8.dp))
                        }
                    }
                }
            }
        }
    }
}