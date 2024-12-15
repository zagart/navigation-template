package com.zagart.navigation.template.feature.bonus.presentation.overview

import androidx.lifecycle.viewModelScope
import com.zagart.navigation.template.feature.bonus.domain.BonusGroupRepository
import com.zagart.navigation.template.feature.bonus.ui.bonusbox.AdvertisementViewData
import com.zagart.navigation.template.feature.bonus.ui.bonusbox.BonusBoxBannerViewData
import com.zagart.navigation.template.feature.bonus.ui.components.models.BonusGroupViewData
import com.zagart.navigation.template.feature.bonus.ui.components.models.BonusItem
import com.zagart.navigation.template.feature.bonus.ui.components.models.BonusLane
import com.zagart.navigation.template.feature.bonus.ui.overview.BonusScreenState
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
class BonusViewModel @Inject constructor() : NavigationViewModel() {

    private val _state = MutableStateFlow(BonusScreenState())
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
                    title = "Bonus",
                    lanes = listOf(
                        BonusLane.BonusBoxBanner(BonusBoxBannerViewData("Bonus Box")),
                        BonusLane.HorizontalList(products.map { BonusItem.Product(it) }),
                        BonusLane.Advertisement(AdvertisementViewData(products[1])),
                        BonusLane.HorizontalList(bonusGroups.map { BonusItem.BonusGroup(it) }),
                        BonusLane.Advertisement(AdvertisementViewData(products[3])),
                    )
                )
            }
        }
    }
}