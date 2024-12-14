package com.zagart.navigation.template.navigation.deeplinks

import android.net.Uri
import com.zagart.navigation.template.presentation.navigation.Destination
import com.zagart.navigation.template.presentation.navigation.BonusBackstack
import com.zagart.navigation.template.presentation.navigation.CookingBackstack
import com.zagart.navigation.template.presentation.navigation.HomeBackstack
import com.zagart.navigation.template.presentation.navigation.MyListBackstack
import com.zagart.navigation.template.presentation.navigation.ProductsBackstack

object DeeplinkConverter {

    fun apply(uri: Uri?): List<Destination> {
        return uri?.pathSegments?.map { segment -> segment.asDestination() }.orEmpty()
    }
}

private fun String.asDestination(): Destination {
    return when (this) {
        "home" -> HomeBackstack()
        "bonus" -> BonusBackstack()
        "cooking" -> CookingBackstack()
        "products" -> ProductsBackstack()
        "mylist" -> MyListBackstack()
        else -> throw IllegalArgumentException("Unsupported destination: $this")
    }
}
