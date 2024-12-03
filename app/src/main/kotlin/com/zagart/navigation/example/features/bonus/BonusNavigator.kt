package com.zagart.navigation.example.features.bonus

import androidx.navigation.NavController
import com.zagart.navigation.example.framework.navigation.Destination
import com.zagart.navigation.example.framework.navigation.Navigator

class BonusNavigator(private val navController: NavController) : Navigator {

    override fun navigate(destination: Destination) {
        navController.navigate(destination)
    }
}