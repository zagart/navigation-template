package com.zagart.navigation.template.shared.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DummyScreen(
    title: String,
    tabIndex: Int,
    onBonusGroupClick: (id: String, backstackIndex: Int) -> Unit,
    onNavigationItemClick: (index: Int) -> Unit,
    modifier: Modifier = Modifier,
    content: String = "Some fancy description",
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = title,
                        fontSize = 34.sp,
                    )
                }
            )
        },
        bottomBar = {
            ExampleBottomBar(
                selectedItemIndex = tabIndex,
                onItemClicked = onNavigationItemClick,
            )
        }
    ) { padding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .clickable {
                onBonusGroupClick(
                    UUID
                        .randomUUID()
                        .toString(),
                    tabIndex,
                )
            }
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = content,
                fontSize = 28.sp,
            )
        }
    }
}