package com.zagart.navigation.template.navigation.hosts

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.zagart.navigation.template.feature.bonus.presentation.segment.BonusGroupScreen
import com.zagart.navigation.template.feature.mylist.presentation.MyListScreen
import com.zagart.navigation.template.navigation.defaultTypeMap
import com.zagart.navigation.template.navigation.screen
import com.zagart.navigation.template.presentation.navigation.BonusGroupDestination
import com.zagart.navigation.template.presentation.navigation.MyListDestination
import com.zagart.navigation.template.ui.Tab

@Composable
fun MyListNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = MyListDestination::class,
        typeMap = defaultTypeMap,
    ) {
        screen<MyListDestination> { MyListScreen() }
        screen<BonusGroupDestination> { destination ->
            BonusGroupScreen(
                tab = Tab.MY_LIST,
                destination = destination,
            )
        }
    }
}