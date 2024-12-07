package com.zagart.navigation.template.features.home.presentation

import androidx.compose.runtime.Immutable
import com.zagart.navigation.template.features.bonusgroup.BonusGroupViewData
import com.zagart.navigation.template.features.productdetails.presentation.ProductViewData

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