package com.zagart.navigation.template.features.cooking

import com.zagart.navigation.template.framework.navigation.Destination
import com.zagart.navigation.template.shared.presentation.Tab
import kotlinx.serialization.Serializable

@Serializable
data class CookingDestination(override val backstackIndex: Int = Tab.COOKING.ordinal) : Destination