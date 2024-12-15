package com.zagart.navigation.template.navigation.hosts

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.zagart.navigation.template.feature.bonus.presentation.segment.BonusGroupScreen
import com.zagart.navigation.template.navigation.defaultTypeMap
import com.zagart.navigation.template.navigation.screen
import com.zagart.navigation.template.presentation.HomeScreen
import com.zagart.navigation.template.presentation.navigation.BonusGroupDestination
import com.zagart.navigation.template.presentation.navigation.HomeDestination
import com.zagart.navigation.template.presentation.navigation.ProductDetailsDestination
import com.zagart.navigation.template.product.presentation.details.ProductDetailsScreen
import com.zagart.navigation.template.ui.Tab

@Composable
fun HomeNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination::class,
        typeMap = defaultTypeMap,
    ) {
        screen<HomeDestination> { HomeScreen() }
        screen<BonusGroupDestination> { destination ->
            BonusGroupScreen(
                tab = Tab.HOME,
                destination = destination,
            )
        }
        screen<ProductDetailsDestination> { ProductDetailsScreen(Tab.HOME.ordinal) }
    }
}