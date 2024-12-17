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
     * @property type Representation of screen (bad practice, to be removed).
     * @property timestamp Makes each destination unique (destinations consumed by [LaunchedEffect]])
     */
    @Parcelize
    @Serializable
    data class Args(
        val backstackIndex: Int = -1,
        val topBarScope: ComponentScope = ComponentScope.Screen,
        val bottomBarScope: ComponentScope = ComponentScope.Application,
        val type: Type = Type.Fullscreen,
        val timestamp: Long = System.currentTimeMillis(),
    ) : Parcelable {

        // [Workaround] Navigation library does not parse custom NavTypes correctly
        override fun toString(): String {
            return Json.encodeToString(this)
        }
    }

    enum class ComponentScope { Application, Screen, None }

    // [Decision] One screen - one representation
    @Parcelize
    @Serializable
    sealed interface Type : Parcelable {

        @Parcelize
        @Serializable
        data object Fullscreen : Type, Parcelable

        @Parcelize
        @Serializable
        data class Dialog(
            val background: Destination
        ) : Type, Parcelable

        @Parcelize
        @Serializable
        data class BottomSheet(
            val background: Destination
        ) : Type, Parcelable
    }
}

fun Destination.ComponentScope.isApplication(): Boolean {
    return this == Destination.ComponentScope.Application
}

fun Destination.ComponentScope.isScreen(): Boolean {
    return this == Destination.ComponentScope.Screen
}

fun Destination.ComponentScope.isNone(): Boolean {
    return this == Destination.ComponentScope.None
}