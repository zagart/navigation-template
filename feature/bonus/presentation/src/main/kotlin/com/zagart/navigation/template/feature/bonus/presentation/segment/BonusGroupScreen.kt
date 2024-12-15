package com.zagart.navigation.template.feature.bonus.presentation.segment

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zagart.navigation.template.feature.bonus.ui.segment.BonusGroupActions
import com.zagart.navigation.template.feature.bonus.ui.segment.BonusGroupScreenUi
import com.zagart.navigation.template.presentation.components.DestinationTypeWrapper
import com.zagart.navigation.template.presentation.navigation.BonusGroupDestination

@Composable
fun BonusGroupScreen(
    destination: BonusGroupDestination,
    modifier: Modifier = Modifier,
    viewModel: BonusGroupViewModel = hiltViewModel(),
    background: @Composable (() -> Unit)? = null,
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
    DestinationTypeWrapper(
        modifier = modifier,
        type = destination.args.type,
        background = background,
        content = { wrapperModifier ->
            BonusGroupScreenUi(
                modifier = wrapperModifier,
                state = state,
                actions = actions
            )
        },
        onDismissRequest = viewModel::onBackClick
    )
}