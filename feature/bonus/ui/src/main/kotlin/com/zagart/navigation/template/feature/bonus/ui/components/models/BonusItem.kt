package com.zagart.navigation.template.feature.bonus.ui.components.models

import androidx.compose.runtime.Immutable
import com.zagart.navigation.template.feature.product.ui.ProductViewData

sealed interface BonusItem {

    @Immutable
    data class Product(
        val viewData: ProductViewData
    ) : BonusItem

    @Immutable
    data class BonusGroup(
        val viewData: BonusGroupViewData
    ) : BonusItem
}