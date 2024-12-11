package com.zagart.navigation.template.feature.home.ui

import com.zagart.navigation.template.feature.bonus.ui.BonusGroupViewData
import com.zagart.navigation.template.feature.product.ui.ProductViewData

data class HomeScreenActions(
    val onBonusGroupClick: (viewData: BonusGroupViewData) -> Unit = {},
    val onNavigationItemClick: (index: Int) -> Unit = {},
    val onProductClick: (viewData: ProductViewData) -> Unit = {},
)