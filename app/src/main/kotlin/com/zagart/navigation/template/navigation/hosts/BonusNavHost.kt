package com.zagart.navigation.template.navigation.hosts

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.zagart.navigation.template.feature.bonus.presentation.bonusbox.BonusBoxScreen
import com.zagart.navigation.template.feature.bonus.presentation.overview.BonusScreen
import com.zagart.navigation.template.feature.bonus.presentation.segment.BonusGroupScreen
import com.zagart.navigation.template.navigation.defaultTypeMap
import com.zagart.navigation.template.navigation.screen
import com.zagart.navigation.template.navigation.screenWithBackground
import com.zagart.navigation.template.presentation.navigation.BonusBoxDestination
import com.zagart.navigation.template.presentation.navigation.BonusDestination
import com.zagart.navigation.template.presentation.navigation.BonusGroupDestination
import com.zagart.navigation.template.presentation.navigation.ProductDetailsDestination
import com.zagart.navigation.template.product.presentation.details.ProductDetailsScreen
import com.zagart.navigation.template.presentation.navigation.ScrollStateHolder

@Composable
fun BonusNavHost(
    navController: NavHostController,
    scrollStateHolder: ScrollStateHolder,
) {
    NavHost(
        navController = navController,
        startDestination = BonusDestination::class,
        typeMap = defaultTypeMap,
    ) {
        screen<BonusDestination> { BonusScreen(it) }
        screen<BonusBoxDestination> { BonusBoxScreen(it, scrollStateHolder) }
        screenWithBackground<BonusGroupDestination>(scrollStateHolder) { destination, background ->
            BonusGroupScreen(
                destination = destination,
                background = background,
            )
        }
        screenWithBackground<ProductDetailsDestination>(scrollStateHolder) { destination, background ->
            ProductDetailsScreen(
                destination = destination,
                background = background,
            )
        }
    }
}