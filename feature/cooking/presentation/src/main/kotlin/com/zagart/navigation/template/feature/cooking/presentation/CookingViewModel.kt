package com.zagart.navigation.template.feature.cooking.presentation

import com.zagart.navigation.template.presentation.navigation.Destination
import com.zagart.navigation.template.presentation.navigation.NavigationViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CookingViewModel @Inject constructor() : NavigationViewModel() {

    fun load(destination: Destination) {
        changeCurrentDestination(destination)
    }
}