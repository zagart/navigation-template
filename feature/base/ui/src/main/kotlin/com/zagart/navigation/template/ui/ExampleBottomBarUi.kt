package com.zagart.navigation.template.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CardGiftcard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.sharp.AutoFixHigh
import androidx.compose.material.icons.sharp.Fastfood
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp

@Composable
fun ExampleBottomBarUi(
    selectedItemIndex: Int,
    modifier: Modifier = Modifier,
    onItemClicked: (index: Int) -> Unit,
) {
    BottomAppBar(
        modifier = modifier,
        contentPadding = PaddingValues(8.dp)
    ) {
        NavigationBarItem(
            selected = selectedItemIndex == 0,
            onClick = { onItemClicked(0) },
            icon = { NavIcon(Icons.Default.Home) }
        )
        Spacer(modifier = Modifier.size(8.dp))
        NavigationBarItem(
            selected = selectedItemIndex == 1,
            onClick = { onItemClicked(1) },
            icon = { NavIcon(Icons.Default.CardGiftcard) }
        )
        Spacer(modifier = Modifier.size(8.dp))
        NavigationBarItem(
            selected = selectedItemIndex == 2,
            onClick = { onItemClicked(2) },
            icon = { NavIcon(Icons.Sharp.AutoFixHigh) }
        )
        Spacer(modifier = Modifier.size(8.dp))
        NavigationBarItem(
            selected = selectedItemIndex == 3,
            onClick = { onItemClicked(3) },
            icon = { NavIcon(Icons.Sharp.Fastfood) }
        )
        Spacer(modifier = Modifier.size(8.dp))
        NavigationBarItem(
            selected = selectedItemIndex == 4,
            onClick = { onItemClicked(4) },
            icon = { NavIcon(Icons.Default.ShoppingCart) }
        )
    }
}

@Composable
fun NavIcon(
    imageVector: ImageVector,
    modifier: Modifier = Modifier,
) {
    Icon(
        modifier = modifier
            .size(40.dp),
        painter = rememberVectorPainter(image = imageVector),
        tint = MaterialTheme.colorScheme.primary,
        contentDescription = "",
    )
}