package com.zagart.navigation.template.presentation.navigation.destinations

import com.zagart.navigation.template.presentation.navigation.Destination
import com.zagart.navigation.template.presentation.navigation.Tab
import kotlinx.serialization.Serializable

@Serializable
data class CookingDestination(
    override val backstackIndex: Int = Tab.COOKING.ordinal
) : Destination