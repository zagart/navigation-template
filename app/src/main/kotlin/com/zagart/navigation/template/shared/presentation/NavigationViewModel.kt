package com.zagart.navigation.template.shared.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zagart.navigation.template.features.bonus.BonusBackstack
import com.zagart.navigation.template.features.bonusgroup.BonusGroupDestination
import com.zagart.navigation.template.features.cooking.CookingBackstack
import com.zagart.navigation.template.features.home.presentation.HomeBackstack
import com.zagart.navigation.template.features.mylist.MyListBackstack
import com.zagart.navigation.template.features.productdetails.presentation.ProductDetailsDestination
import com.zagart.navigation.template.features.productdetails.presentation.ProductViewData
import com.zagart.navigation.template.features.products.ProductsBackstack
import com.zagart.navigation.template.framework.navigation.Destination
import com.zagart.navigation.template.framework.navigation.DestinationChannel
import kotlinx.coroutines.launch

open class NavigationViewModel : ViewModel() {

    fun onBonusGroupClick(id: String, backStackIndex: Int) {
        sendDestination(BonusGroupDestination(id, backStackIndex))
    }

    fun onProductClick(viewData: ProductViewData, backStackIndex: Int) {
        sendDestination(ProductDetailsDestination(viewData.id, backStackIndex))
    }

    fun onNavigationItemClick(index: Int) {
        when (index) {
            0 -> sendDestination(HomeBackstack())
            1 -> sendDestination(BonusBackstack())
            2 -> sendDestination(CookingBackstack())
            3 -> sendDestination(ProductsBackstack())
            4 -> sendDestination(MyListBackstack())
        }
    }

    @Suppress("MemberVisibilityCanBePrivate")
    protected fun sendDestination(destination: Destination) {
        viewModelScope.launch { DestinationChannel.send(destination) }
    }
}