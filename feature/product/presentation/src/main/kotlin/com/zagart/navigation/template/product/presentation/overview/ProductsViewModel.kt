package com.zagart.navigation.template.product.presentation.overview

import com.zagart.navigation.template.presentation.navigation.NavigationViewModel
import com.zagart.navigation.template.presentation.navigation.ProductsDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor() : NavigationViewModel() {

    fun load(destination: ProductsDestination) {
        changeCurrentDestination(destination)
    }
}