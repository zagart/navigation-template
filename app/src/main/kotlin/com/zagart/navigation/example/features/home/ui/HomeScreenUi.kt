package com.zagart.navigation.example.features.home.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zagart.navigation.example.features.bonusgroup.BonusGroupCard
import com.zagart.navigation.example.features.home.presentation.HomeItem
import com.zagart.navigation.example.features.home.presentation.HomeState
import com.zagart.navigation.example.features.productdetails.ProductCard
import com.zagart.navigation.example.features.productdetails.presentation.ProductViewData
import com.zagart.navigation.example.shared.presentation.Tab
import com.zagart.navigation.example.shared.ui.ExampleBottomBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenUi(
    state: HomeState,
    modifier: Modifier = Modifier,
    onNavigationItemClick: (index: Int) -> Unit,
    onProductClick: (viewData: ProductViewData) -> Unit,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Home",
                        fontSize = 34.sp,
                    )
                }
            )
        },
        bottomBar = {
            ExampleBottomBar(
                selectedItemIndex = Tab.HOME.ordinal,
                onItemClicked = onNavigationItemClick,
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
                                is HomeItem.BonusGroup -> BonusGroupCard(item.viewData)
                                is HomeItem.Product -> ProductCard(
                                    viewData = item.viewData,
                                    onClick = onProductClick,
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