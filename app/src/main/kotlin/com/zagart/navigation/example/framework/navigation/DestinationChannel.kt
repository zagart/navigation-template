package com.zagart.navigation.example.framework.navigation

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

object DestinationChannel {

    private val _channel = Channel<Destination>()
    val destinationFlow = _channel.receiveAsFlow()

    suspend fun send(destination: Destination) {
        _channel.send(destination)
    }
}