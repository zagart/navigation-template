package com.zagart.navigation.template

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.zagart.navigation.template.navigation.deeplinks.DeeplinkConverter
import com.zagart.navigation.template.navigation.hosts.BonusNavHost
import com.zagart.navigation.template.navigation.hosts.CookingNavHost
import com.zagart.navigation.template.navigation.hosts.HomeNavHost
import com.zagart.navigation.template.navigation.hosts.MyListNavHost
import com.zagart.navigation.template.navigation.hosts.ProductsNavHost
import com.zagart.navigation.template.presentation.components.bottombar.ExampleBottomBar
import com.zagart.navigation.template.presentation.components.topbar.ExampleTopBar
import com.zagart.navigation.template.presentation.navigation.BackDestination
import com.zagart.navigation.template.presentation.navigation.Backstack
import com.zagart.navigation.template.presentation.navigation.BonusBackstack
import com.zagart.navigation.template.presentation.navigation.CookingBackstack
import com.zagart.navigation.template.presentation.navigation.Destination
import com.zagart.navigation.template.presentation.navigation.DestinationChannel
import com.zagart.navigation.template.presentation.navigation.HomeBackstack
import com.zagart.navigation.template.presentation.navigation.MyListBackstack
import com.zagart.navigation.template.presentation.navigation.ProductsBackstack
import com.zagart.navigation.template.presentation.navigation.ScrollStateHolder
import com.zagart.navigation.template.ui.theme.NavigationTemplateTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            NavigationTemplateTheme {
                val scrollStateHolder = remember { ScrollStateHolder() }
                val homeNavController = rememberNavController()
                val bonusNavController = rememberNavController()
                val cookingNavController = rememberNavController()
                val productsNavController = rememberNavController()
                val myListNavController = rememberNavController()

                var currentBackstack: Backstack by rememberSaveable {
                    mutableStateOf(HomeBackstack())
                }
                val destination = DestinationChannel
                    .destinationFlow
                    .collectAsStateWithLifecycle(currentBackstack)
                    .value

                LaunchedEffect(destination) {
                    if (destination is Backstack) {
                        currentBackstack = destination
                    } else {
                        when (currentBackstack) {
                            is HomeBackstack -> homeNavController.open(destination)
                            is BonusBackstack -> bonusNavController.open(destination)
                            is CookingBackstack -> cookingNavController.open(destination)
                            is ProductsBackstack -> productsNavController.open(destination)
                            is MyListBackstack -> myListNavController.open(destination)
                        }
                    }
                }

                Column {
                    ExampleTopBar()
                    Surface(modifier = Modifier.weight(1f)) {
                        when (currentBackstack) {
                            is HomeBackstack -> HomeNavHost(homeNavController, scrollStateHolder)
                            is BonusBackstack -> BonusNavHost(bonusNavController, scrollStateHolder)
                            is CookingBackstack -> CookingNavHost(cookingNavController)
                            is ProductsBackstack -> ProductsNavHost(productsNavController)
                            is MyListBackstack -> MyListNavHost(myListNavController)
                        }
                    }
                    ExampleBottomBar()
                }
            }
        }
        handleDeeplink(intent)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleDeeplink(intent)
    }

    private fun NavHostController.open(destination: Destination) {
        if (destination is BackDestination) {
            if (!navigateUp()) {
                finish()
            }
        } else {
            navigate(destination)
        }
    }
}

//TODO: Reset backstack/controller on new deeplink?
private fun handleDeeplink(intent: Intent) {
    val destinations = DeeplinkConverter.apply(intent.data)
    val coroutineScope = CoroutineScope(Dispatchers.Main)

    coroutineScope.launch {
        destinations.forEach {
            DestinationChannel.send(it)
            //TODO: Try different destination channel implementations
            delay(50) //controller can't handle destinations faster
        }
    }
}