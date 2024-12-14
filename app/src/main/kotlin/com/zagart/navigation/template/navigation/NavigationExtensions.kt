package com.zagart.navigation.template.navigation

import android.os.Bundle
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.zagart.navigation.template.presentation.navigation.Destination
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.reflect.typeOf

inline fun <reified T : Any> NavGraphBuilder.screen(
    noinline content: @Composable AnimatedContentScope.(T) -> Unit
) {
    composable<T>(
        typeMap = mapOf(
            typeOf<Destination.Args>() to DestinationArgsNavType()
        )
    ) { entry -> content(entry.toRoute()) }
}

/**
 * [toRoute] can't parse nested destination objects, even if those
 * are serializable. Hopefully, it's temporary solution.
 */
class DestinationArgsNavType : NavType<Destination.Args>(isNullableAllowed = false) {

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