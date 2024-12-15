package com.zagart.navigation.template.feature.bonus.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zagart.navigation.template.feature.bonus.ui.bonusbox.AdvertisementViewData

@Composable
fun AdvertisementCard(
    viewData: AdvertisementViewData,
    modifier: Modifier = Modifier,
    onClick: (AdvertisementViewData) -> Unit = {},
) {
    Card(
        modifier = modifier
            .padding(horizontal = 8.dp)
            .clickable(onClick = { onClick(viewData) })
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "Promotion: ${viewData.product.title}",
                fontSize = 20.sp,
                color = Color.Magenta,
            )
        }
    }
}