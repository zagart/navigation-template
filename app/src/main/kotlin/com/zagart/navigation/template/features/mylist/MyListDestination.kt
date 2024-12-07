package com.zagart.navigation.template.features.mylist

import com.zagart.navigation.template.framework.navigation.Destination
import com.zagart.navigation.template.shared.presentation.Tab
import kotlinx.serialization.Serializable

@Serializable
data class MyListDestination(override val backstackIndex: Int = Tab.MY_LIST.ordinal) : Destination