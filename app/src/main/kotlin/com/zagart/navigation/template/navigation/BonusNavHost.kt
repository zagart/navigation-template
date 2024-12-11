package com.zagart.navigation.template.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.zagart.navigation.template.feature.bonus.presentation.BonusGroupScreen
import com.zagart.navigation.template.feature.bonus.presentation.BonusScreen
import com.zagart.navigation.template.presentation.navigation.Tab
import com.zagart.navigation.template.presentation.navigation.destinations.BonusDestination
import com.zagart.navigation.template.presentation.navigation.destinations.BonusGroupDestination
import com.zagart.navigation.template.presentation.navigation.destinations.ProductDetailsDestination
import com.zagart.navigation.template.product.presentation.details.ProductDetailsScreen

@Composable
fun BonusNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BonusDestination::class
    ) {
        composable<BonusDestination> { BonusScreen() }
        composable<BonusGroupDestination> { entry ->
            BonusGroupScreen(
                tabIndex = Tab.BONUS.ordinal,
                destination = entry.toRoute<BonusGroupDestination>(),
            )
        }
        composable<ProductDetailsDestination> { ProductDetailsScreen(Tab.BONUS.ordinal) }
    }
}