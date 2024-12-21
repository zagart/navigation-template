package com.zagart.navigation.template.presentation.navigation

import android.os.Parcelable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Parcelize
@Serializable
sealed interface Destination : Parcelable {

    val args: Args

    /**
     * [Args] represents initial destination state, properties should be feature-agnostic.
     * Initial properties impact can be overridden by feature-specific presentation layer.
     * Feature-specific properties can be added to [Destination] implementations.
     * @property backstackIndex Index of backstack to which this screen belongs to.
     * @property topBarScope Defines scope where top bar should be shown.
     * @property bottomBarScope Defines scope where top bar should be shown.
     * @property timestamp Makes each destination unique (destinations consumed by [LaunchedEffect]])
     */
    @Parcelize
    @Serializable
    data class Args(
        val backstackIndex: Int = -1,
        val topBarScope: ComponentScope = ComponentScope.Screen,
        val bottomBarScope: ComponentScope = ComponentScope.Application,
        val timestamp: Long = System.currentTimeMillis(),
    ) : Parcelable {

        // [Workaround] Navigation library does not parse custom NavTypes correctly
        override fun toString(): String {
            return Json.encodeToString(this)
        }
    }

    @Parcelize
    @Serializable
    enum class ComponentScope : Parcelable { Application, Screen }
}

fun Destination.ComponentScope?.isApplication(): Boolean {
    return this == Destination.ComponentScope.Application
}

fun Destination.ComponentScope?.isScreen(): Boolean {
    return this == Destination.ComponentScope.Screen
}