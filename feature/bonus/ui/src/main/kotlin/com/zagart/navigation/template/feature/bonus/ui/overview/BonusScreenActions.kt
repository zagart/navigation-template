package com.zagart.navigation.template.feature.bonus.ui.overview

import com.zagart.navigation.template.feature.bonus.ui.components.BonusLanesActions
import com.zagart.navigation.template.feature.bonus.ui.components.models.BonusGroupViewData
import com.zagart.navigation.template.feature.product.ui.ProductViewData

data class BonusScreenActions(
    val bonusLanesActions: BonusLanesActions = BonusLanesActions(),
    val onBottomBarItemClick: (index: Int) -> Unit = {},
)