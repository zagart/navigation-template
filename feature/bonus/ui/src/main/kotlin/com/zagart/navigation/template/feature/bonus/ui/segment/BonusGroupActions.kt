package com.zagart.navigation.template.feature.bonus.ui.segment

import com.zagart.navigation.template.feature.product.ui.components.ProductViewData

data class BonusGroupActions(
    val onBack: () -> Unit = {},
    val onBottomBarItemClick: (index: Int) -> Unit = {},
    val onProductClick: (ProductViewData) -> Unit = {},
)