package com.zagart.navigation.template.feature.bonus.ui.overview

import androidx.compose.runtime.Immutable
import com.zagart.navigation.template.feature.bonus.ui.components.models.BonusLane

@Immutable
data class BonusScreenState(
    val title: String = "",
    val showTopBar: Boolean = true,
    val showBottomBar: Boolean = true,
    val lanes: List<BonusLane> = emptyList(),
)