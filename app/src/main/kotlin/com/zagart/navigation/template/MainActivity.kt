package com.zagart.navigation.template

import android.content.Intent
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
import com.zagart.navigation.template.navigation.BonusNavHost
import com.zagart.navigation.template.navigation.CookingNavHost
import com.zagart.navigation.template.navigation.HomeNavHost
import com.zagart.navigation.template.navigation.MyListNavHost
import com.zagart.navigation.template.navigation.ProductsNavHost
import com.zagart.navigation.template.navigation.deeplinks.DeeplinkConverter
import com.zagart.navigation.template.presentation.navigation.Destination
import com.zagart.navigation.template.presentation.navigation.DestinationChannel
import com.zagart.navigation.template.presentation.navigation.backstacks.BonusBackstack
import com.zagart.navigation.template.presentation.navigation.backstacks.CookingBackstack
import com.zagart.navigation.template.presentation.navigation.backstacks.HomeBackstack
import com.zagart.navigation.template.presentation.navigation.backstacks.MyListBackstack
import com.zagart.navigation.template.presentation.navigation.backstacks.ProductsBackstack
import com.zagart.navigation.template.ui.theme.NavigationTemplateTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            NavigationTemplateTheme {
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
        handleDeeplink(intent)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleDeeplink(intent)
    }
}

private fun handleDeeplink(intent: Intent) {
    val destinations = DeeplinkConverter.apply(intent)
    val coroutineScope = CoroutineScope(Dispatchers.Main)

    coroutineScope.launch {
        destinations.forEach {
            DestinationChannel.send(it)
        }
    }
}