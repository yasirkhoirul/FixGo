package com.example.core.component

import android.annotation.SuppressLint
import android.widget.Button
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.material3.Button as MaterialButton
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

enum class ButtonType {
    PRIMARY,
    SECONDARY,
    TERTIARY
}

enum class ButtonSize(val horizontalPadding: Dp, val verticalPadding: Dp) {
    MEDIUM(10.dp, 14.dp),
    LARGE(16.dp, 12.dp)
}

object AppButtonDefaults {
    @Composable
    fun colors(type: ButtonType) = when (type) {
        ButtonType.PRIMARY -> ButtonDefaults.buttonColors()
        ButtonType.SECONDARY -> ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.primary
        )

        ButtonType.TERTIARY -> ButtonDefaults.textButtonColors(
            contentColor = MaterialTheme.colorScheme.primary
        )
    }

    @Composable
    fun border(type: ButtonType, enabled: Boolean) = if (type == ButtonType.SECONDARY) {
        ButtonDefaults.outlinedButtonBorder(enabled)
    } else {
        null
    }

//    @Composable
//    fun padding(type: ButtonType) = if (type == ButtonType.TERTIARY) {
//        ButtonDefaults.TextButtonContentPadding
//    } else {
//        ButtonDefaults.ContentPadding
//    }
}

@Composable
private fun Button(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
    type: ButtonType = ButtonType.PRIMARY,
    contentPadding: PaddingValues,
    shapeRadius: Dp,
    content: @Composable (RowScope.() -> Unit),
) {

    // 2. Use a single generic Button call
    MaterialButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = AppButtonDefaults.colors(type),
        border = AppButtonDefaults.border(type, enabled),
        contentPadding = contentPadding,
        shape = RoundedCornerShape(shapeRadius),
        content = content
    )
}


//Default Button
@Composable
fun Button(
    modifier: Modifier = Modifier,
    text: String,
    type: ButtonType = ButtonType.PRIMARY,
    size: ButtonSize = ButtonSize.MEDIUM,
    shapeRadius: Dp = 8.dp,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
) {
    Button(
        modifier = modifier,
        contentPadding = PaddingValues(
            horizontal = size.horizontalPadding,
            vertical = size.verticalPadding
        ),
        onClick = onClick,
        enabled = enabled,
        type = type,
        shapeRadius = shapeRadius,
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, null)
            Text(text = text, color = MaterialTheme.colorScheme.onPrimary)
            Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, null)
        }
    }
}


@Preview(name = "Button Preview", group = "Button Types")
// Note: Previews themselves don't pass 'type' logic;
// you usually use this for Theme (Dark/Light) or Screen Sizes.
annotation class ButtonStatePreviews

@ButtonStatePreviews
@Composable
fun ButtonCollectionPreview() {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(type = ButtonType.PRIMARY, size = ButtonSize.LARGE, text = "Button")
            Button(type = ButtonType.SECONDARY, size = ButtonSize.LARGE, text = "Button")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(type = ButtonType.PRIMARY, size = ButtonSize.MEDIUM, text = "Button")
            Button(type = ButtonType.SECONDARY, size = ButtonSize.MEDIUM, text = "Button")
        }
    }
}




