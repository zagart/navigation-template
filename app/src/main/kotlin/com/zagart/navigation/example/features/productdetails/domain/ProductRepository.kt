package com.zagart.navigation.example.features.productdetails.domain

object ProductRepository {

    private val products = arrayListOf(
        ProductDomainData(
            id = "0",
            title = "Bread",
        ),
        ProductDomainData(
            id = "1",
            title = "Milk",
        ),
        ProductDomainData(
            id = "2",
            title = "Eggs",
        ),
        ProductDomainData(
            id = "3",
            title = "Whiskey",
        ),
        ProductDomainData(
            id = "4",
            title = "Avocado",
        ),
    )

    @Suppress("RedundantSuspendModifier")
    suspend fun getProducts(): List<ProductDomainData> {
        return products
    }
}