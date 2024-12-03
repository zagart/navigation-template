package com.zagart.navigation.example.features.productdetails

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zagart.navigation.example.features.productdetails.presentation.ProductViewData

@Composable
fun ProductCard(
    viewData: ProductViewData,
    modifier: Modifier = Modifier,
    onClick: (viewData: ProductViewData) -> Unit,
) {
    Card(modifier = modifier
        .size(width = 100.dp, height = 180.dp)
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