package com.zagart.navigation.template.feature.bonus.domain

import com.zagart.navigation.template.feature.product.domain.ProductRepository

object BonusGroupRepository {

    private val bonusGroups = arrayListOf(
        BonusGroupDomainData(
            id = "0",
            title = "Group #1",
        ),
        BonusGroupDomainData(
            id = "1",
            title = "Group #2",
        ),
        BonusGroupDomainData(
            id = "2",
            title = "Group #3",
        ),
        BonusGroupDomainData(
            id = "3",
            title = "Group #4",
        ),
        BonusGroupDomainData(
            id = "4",
            title = "Group #5",
        ),
    )

    suspend fun getBonusGroups(): List<BonusGroupDomainData> {
        val products = ProductRepository.getProducts()
        return bonusGroups.map { it.copy(products = products) }
    }

    suspend fun getBonusGroupById(id: String): BonusGroupDomainData {
        return bonusGroups.first { it.id == id }.copy(products = ProductRepository.getProducts())
    }
}