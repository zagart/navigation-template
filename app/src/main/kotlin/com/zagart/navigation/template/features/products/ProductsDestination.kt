package com.zagart.navigation.template.features.products

import com.zagart.navigation.template.framework.navigation.Destination
import com.zagart.navigation.template.shared.presentation.Tab
import kotlinx.serialization.Serializable

@Serializable
data class ProductsDestination(override val backstackIndex: Int = Tab.PRODUCTS.ordinal) : Destination