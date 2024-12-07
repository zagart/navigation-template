package com.zagart.navigation.template.presentation.navigation.backstacks

import android.os.Parcelable
import com.zagart.navigation.template.presentation.navigation.Destination
import kotlinx.parcelize.Parcelize

@Parcelize
data class CookingBackstack(override val backstackIndex: Int = -1) : Destination, Parcelable