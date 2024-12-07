package com.zagart.navigation.template.presentation.navigation.destinations

import com.zagart.navigation.template.presentation.navigation.Destination
import kotlinx.serialization.Serializable

@Serializable
data class BonusGroupDestination(
    val id: String,
    override val backstackIndex: Int,
) : Destination