package com.zagart.navigation.example.features.cooking

import com.zagart.navigation.example.framework.navigation.Destination
import com.zagart.navigation.example.shared.presentation.Tab
import kotlinx.serialization.Serializable

@Serializable
data class CookingDestination(override val backstackIndex: Int = Tab.COOKING.ordinal) : Destination