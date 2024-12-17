package com.zagart.navigation.template.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.zagart.navigation.template.feature.bonus.presentation.bonusbox.BonusBoxScreen
import com.zagart.navigation.template.presentation.navigation.BonusBoxDestination
import com.zagart.navigation.template.presentation.navigation.Destination
import com.zagart.navigation.template.presentation.navigation.ScrollStateHolder

/**
 * Should be used only for background drawing (when [Destination.Type] is
 * not [Destination.Type.Fullscreen]) and current destination expects other
 * destination to be shown behind the main content.
 * Caused by [NavHost] being able to show only one destination at once.
 */
object ScreenComposableFactory {

    /**
     * In case destination can be shown as background for other destinations,
     * it should be added here.
     */
    @Composable
    fun ScreenByDestination(
        destination: Destination,
        scrollStateHolder: ScrollStateHolder,
    ) {
        return when (destination) {
            is BonusBoxDestination -> BonusBoxScreen(destination, scrollStateHolder)
            else -> throw IllegalArgumentException(
                "Destination is not supported as background: $destination"
            )
        }
    }
}