package com.zagart.navigation.example.features.products

import com.zagart.navigation.example.framework.navigation.Destination
import com.zagart.navigation.example.shared.presentation.Tab
import kotlinx.serialization.Serializable

@Serializable
data class ProductsDestination(override val backstackIndex: Int = Tab.PRODUCTS.ordinal) : Destination