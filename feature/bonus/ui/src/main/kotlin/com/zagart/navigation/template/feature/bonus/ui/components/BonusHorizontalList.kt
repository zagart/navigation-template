package com.zagart.navigation.template.feature.bonus.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zagart.navigation.template.feature.bonus.ui.components.models.BonusGroupViewData
import com.zagart.navigation.template.feature.bonus.ui.components.models.BonusItem
import com.zagart.navigation.template.feature.product.ui.ProductCard
import com.zagart.navigation.template.feature.product.ui.ProductViewData

@Composable
fun BonusHorizontalList(
    modifier: Modifier = Modifier,
    items: List<BonusItem> = emptyList(),
    onBonusGroupClick: (viewData: BonusGroupViewData) -> Unit,
    onProductClick: (viewData: ProductViewData) -> Unit,
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(
            horizontal = 8.dp
        )
    ) {
        items(items) { item ->
            when (item) {
                is BonusItem.BonusGroup -> {
                    BonusGroupCard(
                        viewData = item.viewData,
                        onClick = onBonusGroupClick,
                    )
                }

                is BonusItem.Product -> {
                    ProductCard(
                        viewData = item.viewData,
                        onClick = onProductClick,
                    )
                }
            }
            Spacer(Modifier.size(8.dp))
        }
    }
}