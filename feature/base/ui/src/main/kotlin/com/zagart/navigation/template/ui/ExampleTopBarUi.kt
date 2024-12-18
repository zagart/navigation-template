package com.zagart.navigation.template.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExampleTopBarUi(
    title: String,
    modifier: Modifier = Modifier,
    onBack: (() -> Unit)? = null,
) {
    TopAppBar(
        modifier = modifier,
        navigationIcon = {
            if (onBack != null) {
                IconButton(
                    modifier = Modifier.padding(4.dp),
                    onClick = onBack,
                ) {
                    Icon(
                        modifier = Modifier.size(48.dp),
                        painter = rememberVectorPainter(image = Icons.AutoMirrored.Filled.ArrowBack),
                        tint = MaterialTheme.colorScheme.onBackground,
                        contentDescription = "Back button",
                    )
                }
            }
        },
        title = {
            Text(
                text = title,
                fontSize = 34.sp,
                textAlign = TextAlign.Center,
            )
        }
    )
}