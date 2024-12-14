package com.zagart.navigation.template.navigation.deeplinks

import android.net.Uri
import com.zagart.navigation.template.presentation.navigation.BonusBackstack
import com.zagart.navigation.template.presentation.navigation.CookingBackstack
import com.zagart.navigation.template.presentation.navigation.Destination
import com.zagart.navigation.template.presentation.navigation.HomeBackstack
import com.zagart.navigation.template.presentation.navigation.MyListBackstack
import com.zagart.navigation.template.presentation.navigation.ProductDetailsDestination
import com.zagart.navigation.template.presentation.navigation.ProductsBackstack

object DeeplinkConverter {

    fun apply(uri: Uri?): List<Destination> {
        val segments = uri?.pathSegments.orEmpty()
        return segments.fold(mutableListOf()) { destinations, segment ->
            destinations.apply { addAll(segment.asDestinations()) }
        }
    }
}

private fun String.asDestinations(): List<Destination> {
    val destinations = mutableListOf<Destination>()

    when (this) {
        "home" -> destinations.add(HomeBackstack())
        "bonus" -> destinations.add(BonusBackstack())
        "cooking" -> destinations.add(CookingBackstack())
        "products" -> destinations.add(ProductsBackstack())
        "mylist" -> destinations.add(MyListBackstack())
        "product" -> destinations.add(ProductDetailsDestination(id = "1"))
        else -> throw IllegalArgumentException("Unsupported destination: $this")
    }

    return destinations
}
