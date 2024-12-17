package com.zagart.navigation.template.presentation.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

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