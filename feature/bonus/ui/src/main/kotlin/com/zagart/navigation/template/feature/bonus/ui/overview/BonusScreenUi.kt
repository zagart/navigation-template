package com.zagart.navigation.template.feature.bonus.ui.overview

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zagart.navigation.template.feature.bonus.ui.components.BonusGroupCard
import com.zagart.navigation.template.feature.product.ui.ProductCard
import com.zagart.navigation.template.ui.ExampleBottomBar
import com.zagart.navigation.template.ui.ExampleTopBar

@Composable
fun BonusScreenUi(
    state: BonusScreenState,
    modifier: Modifier = Modifier,
    actions: BonusScreenActions = BonusScreenActions(),
    backstackIndex: Int = 1,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            if (state.showTopBar) {
                ExampleTopBar(title = state.title)
            }
        },
        content = { padding ->
            LazyColumn(
                modifier = Modifier.padding(padding),
            ) {
                item {
                    Card(
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                    ) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Box(
                            modifier = Modifier
                                .height(200.dp)
                                .fillMaxWidth()
                        ) {
                            Text(
                                modifier = Modifier.align(Alignment.Center),
                                text = "Bonus Box",
                                fontSize = 30.sp
                            )
                        }
                    }
                }
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
                                    is BonusItem.BonusGroup -> BonusGroupCard(
                                        viewData = item.viewData,
                                        onClick = actions.onBonusGroupClick
                                    )

                                    is BonusItem.Product -> ProductCard(
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