package com.zagart.navigation.template.presentation.navigation

import android.os.Parcelable
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
     */
    @Parcelize
    @Serializable
    data class Args(
        val backstackIndex: Int = -1,
        val showTopBar: Boolean = true,
        val showBottomBar: Boolean = true,
        val type: Type = Type.Fullscreen,
        val timestamp: Long = System.currentTimeMillis(), //Making each destination unique
    ) : Parcelable {

        // [Workaround] Navigation library does not parse custom NavTypes correctly
        override fun toString(): String {
            return Json.encodeToString(this)
        }
    }

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

@Parcelize
@Serializable
class BackDestination(
    override val args: Destination.Args = Destination.Args(),
) : Destination, Parcelable

@Parcelize
@Serializable
class BonusBoxDestination(
    override val args: Destination.Args = Destination.Args(),
) : Destination, Parcelable

@Parcelize
@Serializable
class BonusDestination(
    override val args: Destination.Args = Destination.Args(),
) : Destination, Parcelable

@Parcelize
@Serializable
class BonusGroupDestination(
    val id: String,
    override val args: Destination.Args = Destination.Args(),
) : Destination, Parcelable

@Parcelize
@Serializable
class CookingDestination(
    override val args: Destination.Args = Destination.Args(),
) : Destination, Parcelable

@Parcelize
@Serializable
class HomeDestination(
    override val args: Destination.Args = Destination.Args(),
) : Destination, Parcelable

@Parcelize
@Serializable
class MyListDestination(
    override val args: Destination.Args = Destination.Args(),
) : Destination, Parcelable

@Parcelize
@Serializable
data class ProductDetailsDestination(
    val id: String,
    override val args: Destination.Args = Destination.Args(),
) : Destination, Parcelable

@Parcelize
@Serializable
class ProductsDestination(
    override val args: Destination.Args = Destination.Args(),
) : Destination, Parcelable