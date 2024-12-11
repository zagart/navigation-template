package com.zagart.navigation.template.feature.product.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProductHorizontalCard(
    viewData: ProductViewData,
    modifier: Modifier = Modifier,
    onClick: (viewData: ProductViewData) -> Unit,
) {
    Card(modifier = modifier
        .height(180.dp)
        .fillMaxWidth()
        .clickable { onClick(viewData) }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = viewData.title
            )
        }
    }
}