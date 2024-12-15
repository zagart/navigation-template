package com.zagart.navigation.template.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ExampleScaffold(
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit
) {
    Column(modifier = modifier) {
        topBar()
        Box(modifier = Modifier.weight(1f)) {
            content(PaddingValues())
        }
        bottomBar()
    }
}