package com.zagart.navigation.template.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zagart.navigation.template.feature.bonus.presentation.BonusGroupScreen
import com.zagart.navigation.template.presentation.navigation.destinations.MyListDestination
import com.zagart.navigation.template.feature.mylist.presentation.MyListScreen
import com.zagart.navigation.template.presentation.navigation.Tab
import com.zagart.navigation.template.presentation.navigation.destinations.BonusGroupDestination

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