package com.zagart.navigation.template.features.bonus

import com.zagart.navigation.template.framework.navigation.Destination
import com.zagart.navigation.template.shared.presentation.Tab
import kotlinx.serialization.Serializable

@Serializable
data class BonusDestination(override val backstackIndex: Int = Tab.BONUS.ordinal) : Destination