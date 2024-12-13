package com.zagart.navigation.template.navigation.deeplinks

import android.content.Intent
import com.zagart.navigation.template.presentation.navigation.Destination
import com.zagart.navigation.template.presentation.navigation.backstacks.BonusBackstack
import com.zagart.navigation.template.presentation.navigation.backstacks.CookingBackstack
import com.zagart.navigation.template.presentation.navigation.backstacks.HomeBackstack
import com.zagart.navigation.template.presentation.navigation.backstacks.MyListBackstack
import com.zagart.navigation.template.presentation.navigation.backstacks.ProductsBackstack

object DeeplinkConverter {

    fun apply(intent: Intent): List<Destination> {
        return if (intent.data != null) {
            val destinations = intent.data?.path?.split("/")?.filterNot { it == "" }
            if (destinations.isNullOrEmpty()) {
                emptyList()
            } else {
                destinations.map { it.asDestination() }
            }
        } else {
            emptyList()
        }
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
