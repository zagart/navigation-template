package com.zagart.navigation.template.presentation.navigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zagart.navigation.template.feature.bonus.ui.BonusGroupViewData
import com.zagart.navigation.template.feature.product.ui.ProductViewData
import com.zagart.navigation.template.presentation.navigation.backstacks.BonusBackstack
import com.zagart.navigation.template.presentation.navigation.backstacks.CookingBackstack
import com.zagart.navigation.template.presentation.navigation.backstacks.HomeBackstack
import com.zagart.navigation.template.presentation.navigation.backstacks.MyListBackstack
import com.zagart.navigation.template.presentation.navigation.backstacks.ProductsBackstack
import com.zagart.navigation.template.presentation.navigation.destinations.BonusGroupDestination
import com.zagart.navigation.template.presentation.navigation.destinations.ProductDetailsDestination
import kotlinx.coroutines.launch

open class NavigationViewModel : ViewModel() {

    fun onBonusGroupClick(bonusGroup: BonusGroupViewData, backstackIndex: Int) {
        sendDestination(BonusGroupDestination(bonusGroup.id, backstackIndex))
    }

    fun onProductClick(product: ProductViewData, backstackIndex: Int) {
        sendDestination(ProductDetailsDestination(product.id, backstackIndex))
    }

    fun onBottomBarItemClick(index: Int) {
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