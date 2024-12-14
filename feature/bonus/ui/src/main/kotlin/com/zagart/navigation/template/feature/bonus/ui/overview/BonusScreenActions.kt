package com.zagart.navigation.template.feature.bonus.ui.overview

import com.zagart.navigation.template.feature.bonus.ui.components.BonusGroupViewData
import com.zagart.navigation.template.feature.product.ui.ProductViewData

data class BonusScreenActions(
    val onBonusGroupClick: (viewData: BonusGroupViewData) -> Unit = {},
    val onBottomBarItemClick: (index: Int) -> Unit = {},
    val onProductClick: (viewData: ProductViewData) -> Unit = {},
)