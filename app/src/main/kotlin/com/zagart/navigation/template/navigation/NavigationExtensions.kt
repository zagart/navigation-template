package com.zagart.navigation.template.navigation

import android.os.Bundle
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.zagart.navigation.template.presentation.navigation.Destination
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.reflect.typeOf

val defaultTypeMap = mapOf(
    typeOf<Destination.Args>() to DestinationArgsNavType()
)

inline fun <reified T : Destination> NavGraphBuilder.screen(
    noinline content: @Composable AnimatedContentScope.(T) -> Unit
) {
    screenWithBackground<T> { destination, _ -> content(destination) }
}

inline fun <reified T : Destination> NavGraphBuilder.screenWithBackground(
    noinline content: @Composable AnimatedContentScope.(T, (@Composable () -> Unit)?) -> Unit
) {
    composable<T>(typeMap = defaultTypeMap) { entry ->
        val destination = entry.toRoute<T>()
        val backgroundDestination = when (val type = destination.args.type) {
            is Destination.Type.BottomSheet -> type.background
            is Destination.Type.Dialog -> type.background
            is Destination.Type.Fullscreen -> null
        }

        content(destination) {
            if (backgroundDestination != null) {
                ScreenComposableFactory.ScreenByDestination(backgroundDestination)
            }
        }
    }
}

/**
 * Workaround, caused by [toRoute] being not able to parse nested destination objects,
 * even if those are serializable. Hopefully, it's temporary solution.
 */
class DestinationArgsNavType : NavType<Destination.Args>(isNullableAllowed = false) {

    /**
     * Not being called by [NavHost] in some cases; [NavHost] calls [Any.toString] instead.
     * Reason for [Destination.Args] workaround.
     */
    override fun put(bundle: Bundle, key: String, value: Destination.Args) {
        bundle.putString(key, Json.encodeToString(value))
    }

    override fun get(bundle: Bundle, key: String): Destination.Args? {
        return bundle.getString(key)?.let { Json.decodeFromString(it) }
    }

    override fun parseValue(value: String): Destination.Args {
        return Json.decodeFromString<Destination.Args>(value)
    }
}