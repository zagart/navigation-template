package com.zagart.navigation.example.shared.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zagart.navigation.example.features.bonus.BonusNavigation
import com.zagart.navigation.example.features.bonusgroup.BonusGroupDestination
import com.zagart.navigation.example.features.cooking.CookingNavigation
import com.zagart.navigation.example.features.home.presentation.HomeNavigation
import com.zagart.navigation.example.features.mylist.MyListNavigation
import com.zagart.navigation.example.features.productdetails.presentation.ProductDetailsDestination
import com.zagart.navigation.example.features.productdetails.presentation.ProductViewData
import com.zagart.navigation.example.features.products.ProductsNavigation
import com.zagart.navigation.example.framework.navigation.Destination
import com.zagart.navigation.example.framework.navigation.DestinationChannel
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
            0 -> sendDestination(HomeNavigation())
            1 -> sendDestination(BonusNavigation())
            2 -> sendDestination(CookingNavigation())
            3 -> sendDestination(ProductsNavigation())
            4 -> sendDestination(MyListNavigation())
        }
    }

    @Suppress("MemberVisibilityCanBePrivate")
    protected fun sendDestination(destination: Destination) {
        viewModelScope.launch { DestinationChannel.send(destination) }
    }
}