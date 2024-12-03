package com.zagart.navigation.example.features.bonus

import com.zagart.navigation.example.framework.navigation.Destination
import com.zagart.navigation.example.shared.presentation.Tab
import kotlinx.serialization.Serializable

@Serializable
data class BonusDestination(override val backstackIndex: Int = Tab.BONUS.ordinal) : Destination