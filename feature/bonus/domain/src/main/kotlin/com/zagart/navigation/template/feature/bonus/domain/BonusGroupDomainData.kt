package com.zagart.navigation.template.feature.bonus.domain

import com.zagart.navigation.template.feature.product.domain.ProductDomainData

data class BonusGroupDomainData(
    val id: String,
    val title: String,
    val products: List<ProductDomainData> = listOf()
)