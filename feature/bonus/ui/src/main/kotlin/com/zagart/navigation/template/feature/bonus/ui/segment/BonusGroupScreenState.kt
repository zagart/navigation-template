package com.zagart.navigation.template.feature.bonus.ui.segment

import com.zagart.navigation.template.feature.bonus.ui.components.models.BonusGroupViewData
import com.zagart.navigation.template.feature.product.ui.components.ProductViewData

data class BonusGroupScreenState(
    val bonusGroup: BonusGroupViewData = BonusGroupViewData(),
    val products: List<ProductViewData> = listOf()
)