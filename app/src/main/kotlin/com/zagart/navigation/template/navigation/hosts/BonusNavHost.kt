package com.zagart.navigation.template.navigation.hosts

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.zagart.navigation.template.feature.bonus.presentation.BonusGroupScreen
import com.zagart.navigation.template.feature.bonus.presentation.BonusScreen
import com.zagart.navigation.template.navigation.screen
import com.zagart.navigation.template.presentation.navigation.BonusDestination
import com.zagart.navigation.template.presentation.navigation.BonusGroupDestination
import com.zagart.navigation.template.presentation.navigation.ProductDetailsDestination
import com.zagart.navigation.template.presentation.navigation.Tab
import com.zagart.navigation.template.product.presentation.details.ProductDetailsScreen

@Composable
fun BonusNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BonusDestination::class,
    ) {
        screen<BonusDestination> { BonusScreen() }
        screen<BonusGroupDestination> { destination ->
            BonusGroupScreen(
                tabIndex = Tab.BONUS.ordinal,
                destination = destination,
            )
        }
        screen<ProductDetailsDestination> { ProductDetailsScreen(Tab.BONUS.ordinal) }
    }
}