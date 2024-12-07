package com.zagart.navigation.template.features.productdetails.presentation

import com.zagart.navigation.template.framework.navigation.Destination
import kotlinx.serialization.Serializable

@Serializable
data class ProductDetailsDestination(
    val id: String,
    override val backstackIndex: Int,
) : Destination