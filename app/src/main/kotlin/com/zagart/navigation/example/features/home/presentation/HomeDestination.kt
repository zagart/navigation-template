package com.zagart.navigation.example.features.home.presentation

import com.zagart.navigation.example.framework.navigation.Destination
import com.zagart.navigation.example.shared.presentation.Tab
import kotlinx.serialization.Serializable

@Serializable
data class HomeDestination(override val backstackIndex: Int = Tab.HOME.ordinal) : Destination