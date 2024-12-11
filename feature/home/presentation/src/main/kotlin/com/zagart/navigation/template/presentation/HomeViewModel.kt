package com.zagart.navigation.template.presentation

import androidx.lifecycle.viewModelScope
import com.zagart.navigation.template.feature.bonus.domain.BonusGroupRepository
import com.zagart.navigation.template.feature.bonus.ui.BonusGroupViewData
import com.zagart.navigation.template.feature.home.ui.HomeItem
import com.zagart.navigation.template.feature.home.ui.HomeLane
import com.zagart.navigation.template.feature.home.ui.HomeState
import com.zagart.navigation.template.feature.product.domain.ProductRepository
import com.zagart.navigation.template.feature.product.ui.ProductViewData
import com.zagart.navigation.template.presentation.navigation.NavigationViewModel
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
            val products = ProductRepository.getProducts().map {
                ProductViewData(it.id, it.title)
            }
            val bonusGroups = BonusGroupRepository.getBonusGroups().map {
                BonusGroupViewData(it.id, it.title)
            }

            _state.update { currentState ->
                currentState.copy(
                    lanes = arrayListOf(
                        HomeLane(items = products.map { HomeItem.Product(it) }),
                        HomeLane(items = products.map { HomeItem.Product(it) }),
                        HomeLane(items = bonusGroups.map { HomeItem.BonusGroup(it) }),
                        HomeLane(items = products.map { HomeItem.Product(it) }),
                        HomeLane(items = products.map { HomeItem.Product(it) }),
                    )
                )
            }
        }
    }
}