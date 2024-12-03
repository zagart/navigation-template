package com.zagart.navigation.example.features.cooking

import androidx.navigation.NavController
import com.zagart.navigation.example.framework.navigation.Destination
import com.zagart.navigation.example.framework.navigation.Navigator

class CookingNavigator(private val navController: NavController) : Navigator {

    override fun navigate(destination: Destination) {
        navController.navigate(destination)
    }
}