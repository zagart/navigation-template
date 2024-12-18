package com.zagart.navigation.template.presentation.navigation

import android.os.Parcelable
import com.zagart.navigation.template.ui.Tab
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class HomeDestination(
    override val args: Destination.Args = Destination.Args(
        backstackIndex = Tab.HOME.ordinal,
        topBarScope = Destination.ComponentScope.Application,
        bottomBarScope = Destination.ComponentScope.Application,
    ),
) : Destination, Parcelable

@Parcelize
@Serializable
data class BonusDestination(
    override val args: Destination.Args = Destination.Args(
        backstackIndex = Tab.BONUS.ordinal,
    ),
) : Destination, Parcelable

@Parcelize
@Serializable
data class CookingDestination(
    override val args: Destination.Args = Destination.Args(
        backstackIndex = Tab.COOKING.ordinal,
    ),
) : Destination, Parcelable

@Parcelize
@Serializable
data class ProductsDestination(
    override val args: Destination.Args = Destination.Args(
        backstackIndex = Tab.PRODUCTS.ordinal,
    ),
) : Destination, Parcelable

@Parcelize
@Serializable
data class MyListDestination(
    override val args: Destination.Args = Destination.Args(
        backstackIndex = Tab.MY_LIST.ordinal,
    ),
) : Destination, Parcelable

@Parcelize
@Serializable
data class BackDestination(
    override val args: Destination.Args = Destination.Args(),
) : Destination, Parcelable

@Parcelize
@Serializable
data class BonusBoxDestination(
    override val args: Destination.Args = Destination.Args(),
) : Destination, Parcelable

@Parcelize
@Serializable
data class BonusGroupDestination(
    val id: String,
    override val args: Destination.Args = Destination.Args(),
) : Destination, Parcelable

@Parcelize
@Serializable
data class ProductDetailsDestination(
    val id: String,
    override val args: Destination.Args = Destination.Args(),
) : Destination, Parcelable