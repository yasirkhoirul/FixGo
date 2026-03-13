package com.example.core.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.component.navbarcomponent.FabMiddle
import com.example.core.theme.FixGoTheme

@Composable
fun MainScaffold(modifier: Modifier = Modifier,content: @Composable (modifier: Modifier) -> Unit) {
    Scaffold(
        floatingActionButton = { FabMiddle(onClick = {}) },
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            NavBar(
                onHomeClick = {},
                onSearchClick = {},
                onNotifClick = {},
                onProfileClick = {},
            )
        }
    ) {
        content(modifier.padding(it))
    }
}

@Preview
@Composable
private fun MainScaffoldPrev() {
    FixGoTheme {
        MainScaffold {
            Column {
                Spacer(modifier = Modifier.size(16.dp))
                Carousel()
            }
        }
    }
}