package com.zagart.navigation.template.features.bonus

import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zagart.navigation.template.features.bonusgroup.BonusGroupDestination
import com.zagart.navigation.template.features.bonusgroup.BonusGroupScreen
import com.zagart.navigation.template.features.productdetails.presentation.ProductDetailsDestination
import com.zagart.navigation.template.features.productdetails.presentation.ProductDetailsScreen
import com.zagart.navigation.template.framework.navigation.Destination
import com.zagart.navigation.template.shared.presentation.Tab
import kotlinx.parcelize.Parcelize

@Parcelize
data class BonusBackstack(override val backstackIndex: Int = -1) : Destination, Parcelable

@Composable
fun BonusNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BonusDestination::class
    ) {
        composable<BonusDestination> { BonusScreen() }
        composable<BonusGroupDestination> { BonusGroupScreen(Tab.BONUS.ordinal) }
        composable<ProductDetailsDestination> { ProductDetailsScreen(Tab.BONUS.ordinal) }
    }
}