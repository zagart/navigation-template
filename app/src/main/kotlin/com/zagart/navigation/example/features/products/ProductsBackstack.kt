package com.zagart.navigation.example.features.products

import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zagart.navigation.example.features.bonusgroup.BonusGroupDestination
import com.zagart.navigation.example.features.bonusgroup.BonusGroupScreen
import com.zagart.navigation.example.features.productdetails.presentation.ProductDetailsDestination
import com.zagart.navigation.example.features.productdetails.presentation.ProductDetailsScreen
import com.zagart.navigation.example.framework.navigation.Destination
import com.zagart.navigation.example.shared.presentation.Tab
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductsBackstack(override val backstackIndex: Int = -1) : Destination, Parcelable

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