package com.zagart.navigation.template.feature.bonus.ui.components

import com.zagart.navigation.template.feature.bonus.ui.bonusbox.AdvertisementViewData
import com.zagart.navigation.template.feature.bonus.ui.components.models.BonusGroupViewData
import com.zagart.navigation.template.feature.product.ui.components.ProductViewData

data class BonusLanesActions(
    val onAdvertisementClick: (AdvertisementViewData) -> Unit = {},
    val onBonusBoxBannerClick: () -> Unit = {},
    val onBonusGroupClick: (viewData: BonusGroupViewData) -> Unit = {},
    val onProductClick: (viewData: ProductViewData) -> Unit = {},
)