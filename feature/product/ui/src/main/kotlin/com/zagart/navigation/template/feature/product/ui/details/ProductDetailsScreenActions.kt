package com.zagart.navigation.template.feature.product.ui.details

data class ProductDetailsScreenActions(
    val onBack: () -> Unit = {},
    val onBottomBarItemClick: (index: Int) -> Unit = {},
)