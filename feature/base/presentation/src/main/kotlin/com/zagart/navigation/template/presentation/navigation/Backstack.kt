package com.zagart.navigation.template.presentation.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

abstract class Backstack(
    override val args: Destination.Args = Destination.Args(),
) : Destination

@Parcelize
class BonusBackstack : Backstack(), Parcelable

@Parcelize
class CookingBackstack : Backstack(), Parcelable

@Parcelize
class HomeBackstack : Backstack(), Parcelable

@Parcelize
class MyListBackstack : Backstack(), Parcelable

@Parcelize
class ProductsBackstack : Backstack(), Parcelable