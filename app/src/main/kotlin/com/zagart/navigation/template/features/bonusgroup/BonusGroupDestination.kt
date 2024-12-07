package com.zagart.navigation.template.features.bonusgroup

import com.zagart.navigation.template.framework.navigation.Destination
import kotlinx.serialization.Serializable

@Serializable
data class BonusGroupDestination(
    val id: String,
    override val backstackIndex: Int,
) : Destination