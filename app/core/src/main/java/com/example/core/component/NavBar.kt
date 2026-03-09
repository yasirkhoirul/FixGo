package com.example.core.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FabNavBar(modifier: Modifier = Modifier, onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
        shape = CircleShape,
        modifier = Modifier
            .size(size = 68.dp)
            .offset(
            y = 50.dp
        )
    ) {
        Icon(Icons.Default.Home, contentDescription = "Service")
    }
}

@Composable
fun NavBar(
    modifier: Modifier = Modifier,
    onHomeClick: () -> Unit,
    onSearchClick: () -> Unit,
    onNotifClick: () -> Unit,
    onProfileClick: () -> Unit,
) {
    BottomAppBar() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            IconButton(onClick = onHomeClick) {
                Icon(Icons.Default.Home, contentDescription = "Home")
            }

            IconButton(onClick = onSearchClick) {
                Icon(Icons.Default.Search, contentDescription = "Search")
            }

            Spacer(modifier = Modifier.width(48.dp))

            IconButton(onClick = onNotifClick) {
                Icon(Icons.Default.Notifications, contentDescription = "Notif")
            }

            IconButton(onClick = onProfileClick) {
                Icon(Icons.Default.Person, contentDescription = "Profile")
            }
        }
    }
}

@Preview
@Composable
private fun NavBarPrev() {

}