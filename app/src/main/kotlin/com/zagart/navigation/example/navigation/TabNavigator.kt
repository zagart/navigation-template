package com.zagart.navigation.example.navigation

import androidx.navigation.NavHostController
import com.zagart.navigation.example.features.bonus.BonusNavigator
import com.zagart.navigation.example.features.cooking.CookingNavigator
import com.zagart.navigation.example.features.home.presentation.HomeNavigator
import com.zagart.navigation.example.features.mylist.MyListNavigator
import com.zagart.navigation.example.features.products.ProductsNavigator
import com.zagart.navigation.example.framework.navigation.Destination
import com.zagart.navigation.example.framework.navigation.Navigator

class TabNavigator : Navigator {

    private var homeNavigator: Navigator? = null
    private var bonusNavigator: Navigator? = null
    private var cookingNavigator: Navigator? = null
    private var productsNavigator: Navigator? = null
    private var myListNavigator: Navigator? = null

    fun init(
        homeNavController: NavHostController,
        bonusNavController: NavHostController,
        cookingNavController: NavHostController,
        productsNavController: NavHostController,
        myListNavController: NavHostController
    ) {
        homeNavigator = HomeNavigator(homeNavController)
        bonusNavigator = BonusNavigator(bonusNavController)
        cookingNavigator = CookingNavigator(cookingNavController)
        productsNavigator = ProductsNavigator(productsNavController)
        myListNavigator = MyListNavigator(myListNavController)
    }

    override fun navigate(destination: Destination) {
        when (destination.backstackIndex) {
            0 -> homeNavigator?.navigate(destination)
            1 -> bonusNavigator?.navigate(destination)
            2 -> cookingNavigator?.navigate(destination)
            3 -> productsNavigator?.navigate(destination)
            4 -> myListNavigator?.navigate(destination)
        }
    }
}