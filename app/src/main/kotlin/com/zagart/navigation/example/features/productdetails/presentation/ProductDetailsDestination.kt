package com.zagart.navigation.example.features.productdetails.presentation

import com.zagart.navigation.example.framework.navigation.Destination
import kotlinx.serialization.Serializable

@Serializable
data class ProductDetailsDestination(
    val id: String,
    override val backstackIndex: Int,
) : Destination