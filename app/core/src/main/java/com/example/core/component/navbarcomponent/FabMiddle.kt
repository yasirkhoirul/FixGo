package com.example.core.component.navbarcomponent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.core.R
import com.example.core.component.modifier.advancedShadow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FabMiddle(modifier: Modifier = Modifier, onClick: () -> Unit) {
    FloatingActionButton(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 0.dp),
        onClick = onClick,
        shape = CircleShape,
        modifier = Modifier
            .size(size = 68.dp)
            .offset(
                y = 68.dp
            )
            .advancedShadow(
                color = MaterialTheme.colorScheme.primary,
                alpha = 0.2f,
                cornersRadius = 34.dp,
                shadowBlurRadius = 15.dp,
                offsetY = 10.dp,
                spread = (-3).dp
            )
            .advancedShadow(
                color = MaterialTheme.colorScheme.primary,
                alpha = 0.2f,
                cornersRadius = 34.dp,
                shadowBlurRadius = 6.dp,
                offsetY = 4.dp,
                spread = (-4).dp
            )
    ) {
        ItemNavBarMid(itemText = "Service") {
            Icon(
                tint = MaterialTheme.colorScheme.onTertiary,
                modifier = Modifier.size(28.dp),
                painter = painterResource(R.drawable.repair),
                contentDescription = "Home"
            )
        }
    }
}

@Composable
fun ItemNavBarMid(itemText: String, icon: @Composable () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        icon()
        Spacer(modifier = Modifier.size(2.dp))
        Text(
            text = itemText,
            style = MaterialTheme.typography.labelSmall.copy(
                fontWeight = FontWeight.Bold
            ),
            color = MaterialTheme.colorScheme.onTertiary
        )
    }
}