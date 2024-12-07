package com.zagart.navigation.template.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ExampleBottomBar(
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
            icon = { NavIcon() }
        )
        Spacer(modifier = Modifier.size(8.dp))
        NavigationBarItem(
            selected = selectedItemIndex == 1,
            onClick = { onItemClicked(1) },
            icon = { NavIcon() }
        )
        Spacer(modifier = Modifier.size(8.dp))
        NavigationBarItem(
            selected = selectedItemIndex == 2,
            onClick = { onItemClicked(2) },
            icon = { NavIcon() }
        )
        Spacer(modifier = Modifier.size(8.dp))
        NavigationBarItem(
            selected = selectedItemIndex == 3,
            onClick = { onItemClicked(3) },
            icon = { NavIcon() }
        )
        Spacer(modifier = Modifier.size(8.dp))
        NavigationBarItem(
            selected = selectedItemIndex == 4,
            onClick = { onItemClicked(4) },
            icon = { NavIcon() }
        )
    }
}

@Composable
fun NavIcon(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(48.dp)
    )
}