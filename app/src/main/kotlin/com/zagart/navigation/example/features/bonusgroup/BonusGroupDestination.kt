package com.zagart.navigation.example.features.bonusgroup

import com.zagart.navigation.example.framework.navigation.Destination
import kotlinx.serialization.Serializable

@Serializable
data class BonusGroupDestination(
    val id: String,
    override val backstackIndex: Int,
) : Destination