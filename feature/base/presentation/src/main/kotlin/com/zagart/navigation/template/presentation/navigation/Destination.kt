package com.zagart.navigation.template.presentation.navigation

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

interface Destination {

    val args: Args

    /**
     * [Args] represents initial destination state, properties should be feature-agnostic.
     * Initial properties impact can be overridden by feature-specific presentation layer.
     * Feature-specific properties can be added to [Destination] implementations.
     */
    @Serializable
    data class Args(
        val backstackIndex: Int = -1,
        val showTopBar: Boolean = true,
        val showBottomBar: Boolean = true,
        val type: Type = Type.FULLSCREEN,
        val timestamp: Long = System.currentTimeMillis(), //Making each destination unique
    ) {

        // [Workaround] Navigation library does not parse custom NavTypes correctly
        override fun toString(): String {
            return Json.encodeToString(this)
        }
    }

    enum class Type { FULLSCREEN, DIALOG, BOTTOM_SHEET }
}

@Serializable
class BackDestination(
    override val args: Destination.Args = Destination.Args(),
) : Destination

@Serializable
class BonusBoxDestination(
    override val args: Destination.Args = Destination.Args(),
) : Destination

@Serializable
class BonusDestination(
    override val args: Destination.Args = Destination.Args(),
) : Destination

@Serializable
class BonusGroupDestination(
    val id: String,
    override val args: Destination.Args = Destination.Args(),
) : Destination

@Serializable
class CookingDestination(
    override val args: Destination.Args = Destination.Args(),
) : Destination

@Serializable
class HomeDestination(
    override val args: Destination.Args = Destination.Args(),
) : Destination

@Serializable
class MyListDestination(
    override val args: Destination.Args = Destination.Args(),
) : Destination

@Serializable
data class ProductDetailsDestination(
    val id: String,
    override val args: Destination.Args = Destination.Args(),
) : Destination

@Serializable
class ProductsDestination(
    override val args: Destination.Args = Destination.Args(),
) : Destination