package com.zagart.navigation.template.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zagart.navigation.template.feature.bonus.presentation.BonusGroupScreen
import com.zagart.navigation.template.feature.cooking.presentation.CookingScreen
import com.zagart.navigation.template.presentation.navigation.Tab
import com.zagart.navigation.template.presentation.navigation.destinations.BonusGroupDestination
import com.zagart.navigation.template.presentation.navigation.destinations.CookingDestination
import com.zagart.navigation.template.presentation.navigation.destinations.ProductDetailsDestination
import com.zagart.navigation.template.product.presentation.details.ProductDetailsScreen

@Composable
fun CookingNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = CookingDestination::class
    ) {
        composable<CookingDestination> { CookingScreen() }
        composable<BonusGroupDestination> { BonusGroupScreen(Tab.COOKING.ordinal) }
        composable<ProductDetailsDestination> { ProductDetailsScreen(Tab.COOKING.ordinal) }
    }
}