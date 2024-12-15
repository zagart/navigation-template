package com.zagart.navigation.template.feature.bonus.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zagart.navigation.template.feature.bonus.ui.components.models.BonusLane

@Composable
fun BonusLanesContent(
    lanes: List<BonusLane>,
    modifier: Modifier = Modifier,
    actions: BonusLanesActions = BonusLanesActions(),
) {
    LazyColumn(
        modifier = modifier,
    ) {
        items(lanes) { lane ->
            when (lane) {
                is BonusLane.Advertisement -> AdvertisementCard(
                    viewData = lane.viewData,
                    onClick = actions.onAdvertisementClick
                )

                is BonusLane.BonusBoxBanner -> BonusBoxBannerCard(
                    viewData = lane.viewData,
                    onClick = actions.onBonusBoxBannerClick
                )

                is BonusLane.HorizontalList -> BonusHorizontalList(
                    items = lane.items,
                    onBonusGroupClick = actions.onBonusGroupClick,
                    onProductClick = actions.onProductClick,
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}