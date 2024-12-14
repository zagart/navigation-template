package com.zagart.navigation.template.feature.bonus.ui.overview

import androidx.compose.runtime.Immutable
import com.zagart.navigation.template.feature.bonus.ui.components.BonusGroupViewData
import com.zagart.navigation.template.feature.product.ui.ProductViewData

@Immutable
data class BonusScreenState(
    val title: String = "",
    val showTopBar: Boolean = true,
    val showBottomBar: Boolean = true,
    val lanes: List<BonusLane> = emptyList(),
)

@Immutable
data class BonusLane(
    val items: List<BonusItem>
)

@Immutable
sealed interface BonusItem {

    data class Product(val viewData: ProductViewData) : BonusItem
    data class BonusGroup(val viewData: BonusGroupViewData) : BonusItem
}