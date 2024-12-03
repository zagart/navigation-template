package com.zagart.navigation.example

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.zagart.navigation.example.features.bonus.BonusNavHost
import com.zagart.navigation.example.features.bonus.BonusNavigation
import com.zagart.navigation.example.features.cooking.CookingNavHost
import com.zagart.navigation.example.features.cooking.CookingNavigation
import com.zagart.navigation.example.features.home.presentation.HomeNavHost
import com.zagart.navigation.example.features.home.presentation.HomeNavigation
import com.zagart.navigation.example.features.mylist.MyListNavHost
import com.zagart.navigation.example.features.mylist.MyListNavigation
import com.zagart.navigation.example.features.products.ProductsNavHost
import com.zagart.navigation.example.features.products.ProductsNavigation
import com.zagart.navigation.example.framework.navigation.Destination
import com.zagart.navigation.example.framework.navigation.DestinationChannel
import com.zagart.navigation.example.navigation.TabNavigator
import com.zagart.navigation.example.ui.theme.NavigationExampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navigator = TabNavigator()
        enableEdgeToEdge()
        setContent {
            NavigationExampleTheme {
                val homeNavController = rememberNavController()
                val bonusNavController = rememberNavController()
                val cookingNavController = rememberNavController()
                val productsNavController = rememberNavController()
                val myListNavController = rememberNavController()

                LaunchedEffect(
                    navigator,
                    homeNavController,
                    bonusNavController,
                    cookingNavController,
                    productsNavController,
                    myListNavController,
                ) {
                    navigator.init(
                        homeNavController,
                        bonusNavController,
                        cookingNavController,
                        productsNavController,
                        myListNavController,
                    )
                }

                var navigationName by rememberSaveable { mutableStateOf("home") }
                val destination = DestinationChannel
                    .destinationFlow
                    .collectAsState(initial = null)
                    .value

                LaunchedEffect(destination) {
                    if (destination != null) {
                        when (destination) {
                            is HomeNavigation -> navigationName = "home"
                            is BonusNavigation -> navigationName = "bonus"
                            is CookingNavigation -> navigationName = "cooking"
                            is ProductsNavigation -> navigationName = "products"
                            is MyListNavigation -> navigationName = "my list"
                            else -> navigator.navigate(destination)
                        }
                    }
                }

                when (navigationName.asDestination()) {
                    is HomeNavigation -> HomeNavHost(homeNavController)
                    is BonusNavigation -> BonusNavHost(bonusNavController)
                    is CookingNavigation -> CookingNavHost(cookingNavController)
                    is ProductsNavigation -> ProductsNavHost(productsNavController)
                    is MyListNavigation -> MyListNavHost(myListNavController)
                }
            }
        }
    }
}

private fun String.asDestination(): Destination {
    return when (this) {
        "home" -> HomeNavigation()
        "bonus" -> BonusNavigation()
        "cooking" -> CookingNavigation()
        "products" -> ProductsNavigation()
        "my list" -> MyListNavigation()
        else -> throw IllegalStateException("Unsupported navigation: $this")
    }
}

@SuppressLint("RestrictedApi")
private fun NavHostController.printStack(): String {
    val routes = currentBackStack.value.map { backStackEntry ->
        backStackEntry.destination.route?.split('.')?.lastOrNull { it.isNotEmpty() }
    }
    val builder = StringBuilder()

    routes.forEach {
        builder.append(it).append("/")
    }
    builder.append("\n")
    return builder.toString()
}