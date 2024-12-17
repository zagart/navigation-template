package com.zagart.navigation.template.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.zagart.navigation.template.presentation.navigation.Destination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DestinationTypeWrapper(
    modifier: Modifier = Modifier,
    type: Destination.Type = Destination.Type.Fullscreen,
    background: (@Composable () -> Unit)? = null,
    content: @Composable (Modifier) -> Unit = {},
    onDismissRequest: () -> Unit = {},
) {
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    when (type) {
        is Destination.Type.BottomSheet -> Box(modifier = modifier) {
            if (background != null) {
                background()
            }
            ModalBottomSheet(
                dragHandle = null,
                onDismissRequest = onDismissRequest,
                shape = BottomSheetDefaults.ExpandedShape,
                sheetState = sheetState,
            ) {
                content(Modifier)
            }
        }

        is Destination.Type.Dialog -> Box(modifier = modifier) {
            if (background != null) {
                background()
            }
            Box(
                modifier = Modifier
                    .alpha(0.8f)
                    .background(Color.Gray)
                    .clickable(onClick = onDismissRequest)
                    .fillMaxSize()
            )
            Surface(
                modifier = Modifier
                    .align(Alignment.Center)
                    .wrapContentSize()
                    .clip(MaterialTheme.shapes.large)
            ) {
                content(
                    Modifier
                        .size(400.dp)
                        .consumeWindowInsets(WindowInsets.systemBars)
                )
            }
        }

        is Destination.Type.Fullscreen -> content(modifier)
    }
}