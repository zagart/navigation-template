package com.zagart.navigation.template.presentation.navigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zagart.navigation.template.presentation.navigation.backstacks.BonusBackstack
import com.zagart.navigation.template.presentation.navigation.backstacks.CookingBackstack
import com.zagart.navigation.template.presentation.navigation.backstacks.HomeBackstack
import com.zagart.navigation.template.presentation.navigation.backstacks.MyListBackstack
import com.zagart.navigation.template.presentation.navigation.backstacks.ProductsBackstack
import com.zagart.navigation.template.presentation.navigation.destinations.BonusGroupDestination
import com.zagart.navigation.template.presentation.navigation.destinations.ProductDetailsDestination
import kotlinx.coroutines.launch

open class NavigationViewModel : ViewModel() {

    fun onBonusGroupClick(bonusGroupId: String, backstackIndex: Int) {
        sendDestination(BonusGroupDestination(bonusGroupId, backstackIndex))
    }

    fun onProductClick(productId: String, backstackIndex: Int) {
        sendDestination(ProductDetailsDestination(productId, backstackIndex))
    }

    fun onTabItemClick(index: Int) {
        when (index) {
            Tab.HOME.ordinal -> sendDestination(HomeBackstack())
            Tab.BONUS.ordinal -> sendDestination(BonusBackstack())
            Tab.COOKING.ordinal -> sendDestination(CookingBackstack())
            Tab.PRODUCTS.ordinal -> sendDestination(ProductsBackstack())
            Tab.MY_LIST.ordinal -> sendDestination(MyListBackstack())
        }
    }

    @Suppress("MemberVisibilityCanBePrivate")
    protected fun sendDestination(destination: Destination) {
        viewModelScope.launch { DestinationChannel.send(destination) }
    }
}