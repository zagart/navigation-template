package com.zagart.navigation.template.navigation.hosts

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.zagart.navigation.template.feature.bonus.presentation.BonusGroupScreen
import com.zagart.navigation.template.feature.mylist.presentation.MyListScreen
import com.zagart.navigation.template.navigation.screen
import com.zagart.navigation.template.presentation.navigation.BonusGroupDestination
import com.zagart.navigation.template.presentation.navigation.MyListDestination
import com.zagart.navigation.template.presentation.navigation.Tab

@Composable
fun MyListNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = MyListDestination::class,
    ) {
        screen<MyListDestination> { MyListScreen() }
        screen<BonusGroupDestination> { destination ->
            BonusGroupScreen(
                tabIndex = Tab.MY_LIST.ordinal,
                destination = destination,
            )
        }
    }
}