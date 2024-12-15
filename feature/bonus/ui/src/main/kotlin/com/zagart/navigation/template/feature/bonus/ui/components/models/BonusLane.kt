package com.zagart.navigation.template.feature.bonus.ui.components.models

import androidx.compose.runtime.Immutable
import com.zagart.navigation.template.feature.bonus.ui.bonusbox.AdvertisementViewData
import com.zagart.navigation.template.feature.bonus.ui.bonusbox.BonusBoxBannerViewData

sealed interface BonusLane {

    @Immutable
    data class Advertisement(
        val viewData: AdvertisementViewData,
    ) : BonusLane

    @Immutable
    data class BonusBoxBanner(
        val viewData: BonusBoxBannerViewData,
    ) : BonusLane

    @Immutable
    data class HorizontalList(
        val items: List<BonusItem>
    ) : BonusLane
}