package com.zagart.navigation.template.features.home.presentation

import androidx.lifecycle.viewModelScope
import com.zagart.navigation.template.features.productdetails.domain.ProductRepository
import com.zagart.navigation.template.features.productdetails.presentation.ProductViewData
import com.zagart.navigation.template.shared.presentation.NavigationViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : NavigationViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val products = ProductRepository.getProducts().map { ProductViewData(it.id, it.title) }

            _state.update { currentState ->
                currentState.copy(
                    lanes = arrayListOf(
                        HomeLane(items = products.map { HomeItem.Product(it) }),
                        HomeLane(items = products.map { HomeItem.Product(it) }),
                        HomeLane(items = products.map { HomeItem.Product(it) }),
                        HomeLane(items = products.map { HomeItem.Product(it) }),
                        HomeLane(items = products.map { HomeItem.Product(it) }),
                    )
                )
            }
        }
    }
}