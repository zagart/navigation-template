package com.zagart.navigation.template.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zagart.navigation.template.feature.bonus.presentation.BonusGroupScreen
import com.zagart.navigation.template.presentation.navigation.Tab
import com.zagart.navigation.template.presentation.navigation.destinations.BonusGroupDestination
import com.zagart.navigation.template.presentation.navigation.destinations.ProductsDestination
import com.zagart.navigation.template.product.presentation.ProductsScreen
import com.zagart.navigation.template.presentation.navigation.destinations.ProductDetailsDestination
import com.zagart.navigation.template.product.presentation.details.ProductDetailsScreen

@Composable
fun ProductsNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ProductsDestination::class
    ) {
        composable<ProductsDestination> { ProductsScreen() }
        composable<BonusGroupDestination> { BonusGroupScreen(Tab.PRODUCTS.ordinal) }
        composable<ProductDetailsDestination> { ProductDetailsScreen(Tab.PRODUCTS.ordinal) }
    }
}