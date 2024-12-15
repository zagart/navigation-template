package com.zagart.navigation.template.feature.product.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zagart.navigation.template.ui.ExampleBottomBar
import com.zagart.navigation.template.ui.ExampleTopBar

@Composable
fun ProductDetailsScreenUi(
    state: ProductDetailsScreenState,
    modifier: Modifier = Modifier,
    actions: ProductDetailsScreenActions = ProductDetailsScreenActions()
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            if (state.showTopBar) {
                ExampleTopBar(title = state.title)
            }
        },
        content = { padding ->
            Column(modifier = Modifier.padding(padding)) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = state.product.title,
                    fontSize = 30.sp
                )
            }
        },
        bottomBar = {
            if (state.showTopBar) {
                ExampleBottomBar(
                    selectedItemIndex = state.currentTab.ordinal,
                    onItemClicked = actions.onBottomBarItemClick
                )
            }
        }
    )
}