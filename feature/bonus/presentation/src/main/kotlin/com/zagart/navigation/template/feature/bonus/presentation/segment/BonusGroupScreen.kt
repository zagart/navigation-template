package com.zagart.navigation.template.feature.bonus.presentation.segment

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zagart.navigation.template.feature.bonus.ui.segment.BonusGroupActions
import com.zagart.navigation.template.feature.bonus.ui.segment.BonusGroupScreenUi
import com.zagart.navigation.template.presentation.navigation.BonusGroupDestination
import com.zagart.navigation.template.presentation.navigation.Destination

@Composable
fun BonusGroupScreen(
    destination: BonusGroupDestination,
    modifier: Modifier = Modifier,
    viewModel: BonusGroupViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val actions = remember(viewModel) {
        BonusGroupActions(
            onProductClick = viewModel::onProductClick,
            onBottomBarItemClick = viewModel::onBottomBarItemClick
        )
    }

    LaunchedEffect(destination) {
        viewModel.load(destination)
    }

    BackHandler(onBack = viewModel::onBackClick)

    when (destination.args.type) {
        Destination.Type.FULLSCREEN -> BonusGroupScreenUi(
            modifier = modifier,
            state = state,
            actions = actions
        )

        Destination.Type.DIALOG -> Dialog(
            onDismissRequest = viewModel::onBackClick
        ) {
            BonusGroupScreenUi(
                modifier = modifier.size(400.dp),
                state = state,
                actions = actions
            )
        }

        Destination.Type.BOTTOM_SHEET -> Box(
            modifier = modifier
                .background(Color.Gray.copy(alpha = 0.8f))
                .fillMaxSize()
        ) {
            BonusGroupScreenUi(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .height(400.dp),
                state = state,
                actions = actions
            )
        }
    }
}