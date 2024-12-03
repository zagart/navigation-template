package com.zagart.navigation.example.features.mylist

import com.zagart.navigation.example.framework.navigation.Destination
import com.zagart.navigation.example.shared.presentation.Tab
import kotlinx.serialization.Serializable

@Serializable
data class MyListDestination(override val backstackIndex: Int = Tab.MY_LIST.ordinal) : Destination