package com.zagart.navigation.example.features.mylist

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zagart.navigation.example.features.bonusgroup.BonusGroupDestination
import com.zagart.navigation.example.features.bonusgroup.BonusGroupScreen
import com.zagart.navigation.example.framework.navigation.Destination
import com.zagart.navigation.example.shared.presentation.Tab
import kotlinx.serialization.Serializable

@Serializable
data class MyListNavigation(override val backstackIndex: Int = -1) : Destination

@Composable
fun MyListNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = MyListDestination::class
    ) {
        composable<MyListDestination> { MyListScreen() }
        composable<BonusGroupDestination> { BonusGroupScreen(Tab.MY_LIST.ordinal) }
    }
}