package com.zagart.navigation.template.product.presentation.details

import androidx.lifecycle.viewModelScope
import com.zagart.navigation.template.feature.product.domain.ProductRepository
import com.zagart.navigation.template.feature.product.ui.components.ProductViewData
import com.zagart.navigation.template.feature.product.ui.details.ProductDetailsScreenState
import com.zagart.navigation.template.presentation.navigation.NavigationViewModel
import com.zagart.navigation.template.presentation.navigation.ProductDetailsDestination
import com.zagart.navigation.template.presentation.navigation.isScreen
import com.zagart.navigation.template.ui.Tab
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor() : NavigationViewModel() {

    private val _state = MutableStateFlow(ProductDetailsScreenState())
    val state = _state.asStateFlow()

    fun load(destination: ProductDetailsDestination) {
        changeCurrentDestination(destination)
        viewModelScope.launch {
            val product = ProductRepository
                .getProductById(destination.id)
                .run { ProductViewData(id, title) }

            _state.update { currentState ->
                currentState.copy(
                    currentTab = Tab.entries[destination.args.backstackIndex],
                    product = product,
                    title = "Product details",
                    showTopBar = destination.args.topBarScope.isScreen(),
                    showBottomBar = destination.args.bottomBarScope.isScreen(),
                )
            }
        }
    }
}