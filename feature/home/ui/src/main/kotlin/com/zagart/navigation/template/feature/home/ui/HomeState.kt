package com.zagart.navigation.template.feature.home.ui

import androidx.compose.runtime.Immutable
import com.zagart.navigation.template.feature.bonus.ui.BonusGroupViewData
import com.zagart.navigation.template.feature.product.ui.ProductViewData

@Immutable
data class HomeState(
    val lanes: List<HomeLane> = emptyList()
)

@Immutable
data class HomeLane(
    val items: List<HomeItem>
)

@Immutable
sealed interface HomeItem {

    data class Product(val viewData: ProductViewData) : HomeItem
    data class BonusGroup(val viewData: BonusGroupViewData) : HomeItem
}