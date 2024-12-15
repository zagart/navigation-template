package com.zagart.navigation.template.feature.bonus.ui.bonusbox

import androidx.compose.runtime.Immutable
import com.zagart.navigation.template.feature.bonus.ui.components.models.BonusLane
import com.zagart.navigation.template.ui.Tab

@Immutable
data class BonusBoxScreenState(
    val currentTab: Tab = Tab.BONUS,
    val lanes: List<BonusLane> = emptyList(),
    val showTopBar: Boolean = true,
    val showBottomBar: Boolean = true,
    val title: String = "Bonus Box",
)