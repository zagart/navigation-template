package com.zagart.navigation.template.feature.bonus.ui.overview

import com.zagart.navigation.template.feature.bonus.ui.components.BonusLanesActions

data class BonusScreenActions(
    val bonusLanesActions: BonusLanesActions = BonusLanesActions(),
    val onBottomBarItemClick: (index: Int) -> Unit = {},
)