package com.zagart.navigation.example.features.home.presentation

import androidx.navigation.NavController
import com.zagart.navigation.example.framework.navigation.Destination
import com.zagart.navigation.example.framework.navigation.Navigator

class HomeNavigator(private val navController: NavController) : Navigator {

    override fun navigate(destination: Destination) {
        navController.navigate(destination)
    }
}