package com.zagart.navigation.template.features.home.presentation

import com.zagart.navigation.template.framework.navigation.Destination
import com.zagart.navigation.template.shared.presentation.Tab
import kotlinx.serialization.Serializable

@Serializable
data class HomeDestination(override val backstackIndex: Int = Tab.HOME.ordinal) : Destination