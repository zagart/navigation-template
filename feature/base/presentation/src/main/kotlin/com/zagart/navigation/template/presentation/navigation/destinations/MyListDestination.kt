package com.zagart.navigation.template.presentation.navigation.destinations

import com.zagart.navigation.template.presentation.navigation.Destination
import com.zagart.navigation.template.presentation.navigation.Tab
import kotlinx.serialization.Serializable

@Serializable
data class MyListDestination(
    override val backstackIndex: Int = Tab.MY_LIST.ordinal
) : Destination