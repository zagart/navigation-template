package com.zagart.navigation.template.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zagart.navigation.template.feature.bonus.presentation.BonusGroupScreen
import com.zagart.navigation.template.presentation.HomeScreen
import com.zagart.navigation.template.presentation.navigation.Tab
import com.zagart.navigation.template.presentation.navigation.destinations.BonusGroupDestination
import com.zagart.navigation.template.presentation.navigation.destinations.HomeDestination
import com.zagart.navigation.template.presentation.navigation.destinations.ProductDetailsDestination
import com.zagart.navigation.template.product.presentation.details.ProductDetailsScreen

@Composable
fun HomeNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination::class
    ) {
        composable<HomeDestination> { HomeScreen() }
        composable<BonusGroupDestination> { BonusGroupScreen(Tab.HOME.ordinal) }
        composable<ProductDetailsDestination> { ProductDetailsScreen(Tab.HOME.ordinal) }
    }
}