package com.zagart.navigation.template.feature.bonus.presentation.bonusbox

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zagart.navigation.template.feature.bonus.ui.bonusbox.BonusBoxScreenActions
import com.zagart.navigation.template.feature.bonus.ui.bonusbox.BonusBoxScreenUi
import com.zagart.navigation.template.feature.bonus.ui.components.BonusLanesActions
import com.zagart.navigation.template.presentation.navigation.BonusBoxDestination
import com.zagart.navigation.template.presentation.navigation.ScrollStateHolder

@Composable
fun BonusBoxScreen(
    destination: BonusBoxDestination,
    scrollStateHolder: ScrollStateHolder,
    modifier: Modifier = Modifier,
    viewModel: BonusBoxViewModel = hiltViewModel(),
) {
    val backstackIndex = destination.args.backstackIndex
    val state by viewModel.state.collectAsStateWithLifecycle()
    val actions = remember(viewModel) {
        BonusBoxScreenActions(
            bonusLanesActions = BonusLanesActions(
                onAdvertisementClick = {},
                onBonusBoxBannerClick = { viewModel.onBonusBoxClick(backstackIndex) },
                onBonusGroupClick = { viewModel.onBonusGroupClick(it, backstackIndex) },
                onProductClick = { viewModel.onProductClick(it, backstackIndex) }
            ),
            onBack = viewModel::onBack,
            onBottomBarItemClick = viewModel::onBottomBarItemClick
        )
    }

    LaunchedEffect(destination) {
        viewModel.load(destination)
    }

    BackHandler(onBack = viewModel::onBack)
    BonusBoxScreenUi(
        state = state,
        listState = scrollStateHolder.getListState(destination),
        modifier = modifier,
        actions = actions,
    )
}