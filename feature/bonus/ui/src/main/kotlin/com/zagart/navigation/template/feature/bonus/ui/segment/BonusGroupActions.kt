package com.zagart.navigation.template.feature.bonus.ui.segment

import com.zagart.navigation.template.feature.product.ui.ProductViewData

data class BonusGroupActions(
    val onProductClick: (ProductViewData) -> Unit = {},
    val onBottomBarItemClick: (index: Int) -> Unit = {},
)