package com.zagart.navigation.template.navigation.hosts

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.zagart.navigation.template.feature.bonus.presentation.BonusGroupScreen
import com.zagart.navigation.template.navigation.defaultTypeMap
import com.zagart.navigation.template.navigation.screen
import com.zagart.navigation.template.presentation.navigation.BonusGroupDestination
import com.zagart.navigation.template.presentation.navigation.ProductDetailsDestination
import com.zagart.navigation.template.presentation.navigation.ProductsDestination
import com.zagart.navigation.template.presentation.navigation.Tab
import com.zagart.navigation.template.product.presentation.ProductsScreen
import com.zagart.navigation.template.product.presentation.details.ProductDetailsScreen

@Composable
fun ProductsNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ProductsDestination::class,
        typeMap = defaultTypeMap,
    ) {
        screen<ProductsDestination> { ProductsScreen() }
        screen<BonusGroupDestination> { destination ->
            BonusGroupScreen(
                tabIndex = Tab.PRODUCTS.ordinal,
                destination = destination,
            )
        }
        screen<ProductDetailsDestination> { ProductDetailsScreen(Tab.PRODUCTS.ordinal) }
    }
}