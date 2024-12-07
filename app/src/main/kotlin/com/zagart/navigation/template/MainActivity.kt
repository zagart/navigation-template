package com.zagart.navigation.template

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
import androidx.navigation.compose.rememberNavController
import com.zagart.navigation.template.features.bonus.BonusBackstack
import com.zagart.navigation.template.features.bonus.BonusNavHost
import com.zagart.navigation.template.features.cooking.CookingBackstack
import com.zagart.navigation.template.features.cooking.CookingNavHost
import com.zagart.navigation.template.features.home.presentation.HomeBackstack
import com.zagart.navigation.template.features.home.presentation.HomeNavHost
import com.zagart.navigation.template.features.mylist.MyListBackstack
import com.zagart.navigation.template.features.mylist.MyListNavHost
import com.zagart.navigation.template.features.products.ProductsBackstack
import com.zagart.navigation.template.features.products.ProductsNavHost
import com.zagart.navigation.template.framework.navigation.Destination
import com.zagart.navigation.template.framework.navigation.DestinationChannel
import com.zagart.navigation.template.ui.theme.NavigationExampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            NavigationExampleTheme {
                val homeNavController = rememberNavController()
                val bonusNavController = rememberNavController()
                val cookingNavController = rememberNavController()
                val productsNavController = rememberNavController()
                val myListNavController = rememberNavController()

                var currentBackstack: Destination by rememberSaveable {
                    mutableStateOf(HomeBackstack())
                }
                val destination = DestinationChannel
                    .destinationFlow
                    .collectAsState(currentBackstack)
                    .value

                LaunchedEffect(destination) {
                    when (destination) {
                        is HomeBackstack -> currentBackstack = HomeBackstack()
                        is BonusBackstack -> currentBackstack = BonusBackstack()
                        is CookingBackstack -> currentBackstack = CookingBackstack()
                        is ProductsBackstack -> currentBackstack = ProductsBackstack()
                        is MyListBackstack -> currentBackstack = MyListBackstack()
                        else -> when (currentBackstack) {
                            is HomeBackstack -> homeNavController.navigate(destination)
                            is BonusBackstack -> bonusNavController.navigate(destination)
                            is CookingBackstack -> cookingNavController.navigate(destination)
                            is ProductsBackstack -> productsNavController.navigate(destination)
                            is MyListBackstack -> myListNavController.navigate(destination)
                        }
                    }
                }

                when (currentBackstack) {
                    is HomeBackstack -> HomeNavHost(homeNavController)
                    is BonusBackstack -> BonusNavHost(bonusNavController)
                    is CookingBackstack -> CookingNavHost(cookingNavController)
                    is ProductsBackstack -> ProductsNavHost(productsNavController)
                    is MyListBackstack -> MyListNavHost(myListNavController)
                }
            }
        }
    }
}