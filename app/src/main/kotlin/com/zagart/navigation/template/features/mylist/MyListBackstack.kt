package com.zagart.navigation.template.features.mylist

import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zagart.navigation.template.features.bonusgroup.BonusGroupDestination
import com.zagart.navigation.template.features.bonusgroup.BonusGroupScreen
import com.zagart.navigation.template.framework.navigation.Destination
import com.zagart.navigation.template.shared.presentation.Tab
import kotlinx.parcelize.Parcelize

@Parcelize
data class MyListBackstack(override val backstackIndex: Int = -1) : Destination, Parcelable

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