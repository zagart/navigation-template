package com.zagart.navigation.template.feature.bonus.ui.bonusbox

import com.zagart.navigation.template.feature.bonus.ui.components.BonusLanesActions

data class BonusBoxScreenActions(
    val bonusLanesActions: BonusLanesActions = BonusLanesActions(),
    val onBottomBarItemClick: (index: Int) -> Unit = {},
)