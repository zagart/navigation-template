package com.zagart.navigation.template.presentation.navigation

import android.os.Parcelable
import com.zagart.navigation.template.ui.Tab
import kotlinx.parcelize.Parcelize

sealed interface Backstack : Destination {

    companion object {

        fun from(backstackIndex: Int): Backstack {
            return when (backstackIndex) {
                Tab.HOME.ordinal -> HomeBackstack()
                Tab.BONUS.ordinal -> BonusBackstack()
                Tab.COOKING.ordinal -> CookingBackstack()
                Tab.PRODUCTS.ordinal -> ProductsBackstack()
                Tab.MY_LIST.ordinal -> MyListBackstack()
                else -> throw IllegalArgumentException("Backstack with index $backstackIndex does not exist")
            }
        }
    }
}

@Parcelize
data class BonusBackstack(
    override val args: Destination.Args = Destination.Args(Tab.BONUS.ordinal),
) : Backstack, Parcelable

@Parcelize
data class CookingBackstack(
    override val args: Destination.Args = Destination.Args(Tab.COOKING.ordinal),
) : Backstack, Parcelable

@Parcelize
data class HomeBackstack(
    override val args: Destination.Args = Destination.Args(Tab.HOME.ordinal),
) : Backstack, Parcelable

@Parcelize
data class MyListBackstack(
    override val args: Destination.Args = Destination.Args(Tab.MY_LIST.ordinal),
) : Backstack, Parcelable

@Parcelize
data class ProductsBackstack(
    override val args: Destination.Args = Destination.Args(Tab.PRODUCTS.ordinal),
) : Backstack, Parcelable