package com.zagart.navigation.template.presentation.navigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zagart.navigation.template.feature.bonus.ui.components.models.BonusGroupViewData
import com.zagart.navigation.template.feature.product.ui.components.ProductViewData
import com.zagart.navigation.template.ui.Tab
import kotlinx.coroutines.launch

abstract class NavigationViewModel : ViewModel() {

    open fun onBackClick() {
        sendDestination(BackDestination())
    }

    open fun onBonusBoxClick(backstackIndex: Int) {
        sendDestination(
            BonusBoxDestination(
                args = Destination.Args(backstackIndex)
            )
        )
    }

    open fun onBonusGroupClick(bonusGroup: BonusGroupViewData, backstackIndex: Int) {
        sendDestination(
            BonusGroupDestination(
                id = bonusGroup.id,
                args = Destination.Args(backstackIndex)
            )
        )
    }

    open fun onProductClick(product: ProductViewData, backstackIndex: Int) {
        sendDestination(
            ProductDetailsDestination(
                id = product.id,
                args = Destination.Args(backstackIndex)
            )
        )
    }

    open fun onBottomBarItemClick(index: Int) {
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