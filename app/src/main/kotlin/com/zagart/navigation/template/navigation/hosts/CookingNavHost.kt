package com.zagart.navigation.template.navigation.hosts

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.zagart.navigation.template.feature.bonus.presentation.BonusGroupScreen
import com.zagart.navigation.template.feature.cooking.presentation.CookingScreen
import com.zagart.navigation.template.navigation.screen
import com.zagart.navigation.template.presentation.navigation.BonusGroupDestination
import com.zagart.navigation.template.presentation.navigation.CookingDestination
import com.zagart.navigation.template.presentation.navigation.ProductDetailsDestination
import com.zagart.navigation.template.presentation.navigation.Tab
import com.zagart.navigation.template.product.presentation.details.ProductDetailsScreen

@Composable
fun CookingNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = CookingDestination::class,
    ) {
        screen<CookingDestination> { CookingScreen() }
        screen<BonusGroupDestination> { destination ->
            BonusGroupScreen(
                tabIndex = Tab.COOKING.ordinal,
                destination = destination,
            )
        }
        screen<ProductDetailsDestination> { ProductDetailsScreen(Tab.COOKING.ordinal) }
    }
}