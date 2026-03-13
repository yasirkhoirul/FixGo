package com.example.core.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.core.theme.FixGoTheme
import com.example.core.theme.FixGoThemeExt.semanticColors
import androidx.compose.material3.Button as MaterialButton

enum class ButtonType {
    PRIMARY,
    SECONDARY,
    TERTIARY
}

/**
 * Defines the sizing and internal padding for the button.
 *
 * @property horizontalPadding The horizontal space between the border and content.
 * @property verticalPadding The vertical space between the border and content.
 */
enum class ButtonSize(val horizontalPadding: Dp, val verticalPadding: Dp) {
    MEDIUM(10.dp, 14.dp),
    LARGE(16.dp, 12.dp)
}

object AppButtonDefaults {

    /**
     * Resolves the appropriate [ButtonColors] for the given [ButtonType].
     */
    @Composable
    fun colors(type: ButtonType): ButtonColors {
        val color = MaterialTheme.colorScheme
        return when (type) {
            ButtonType.PRIMARY -> ButtonDefaults.buttonColors(
                disabledContainerColor = color.secondaryContainer,
                disabledContentColor = color.secondary,
            )

            ButtonType.SECONDARY -> ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                disabledContentColor = color.secondary
            )

            ButtonType.TERTIARY -> ButtonDefaults.textButtonColors(
                contentColor = semanticColors.info,
                disabledContentColor = color.secondary,
            )
        }
    }

    /**
     * Resolves the border stroke. Only [ButtonType.SECONDARY] returns a non-null border.
     *
     * @param enabled Changes the border color to a disabled state if false.
     */
    @Composable
    fun border(type: ButtonType, enabled: Boolean): BorderStroke? {
        val color =
            if (enabled) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondaryContainer
        val buttonBorder = BorderStroke(1.dp, color = color)

        if (type == ButtonType.SECONDARY) {
            return buttonBorder
        }
        return null
    }

}

/**
 * Internal base Button component that wraps Material3's Button.
 * Used to centralize styling logic for the public variants below.
 */
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

/**
 * Standard Default Button.
 * Includes localized text and automatically adds arrow icons for Primary and Secondary types.
 *
 * @param modifier The modifier to be applied to the button.
 * @param text The text to be displayed inside the button.
 * @param type The [ButtonType] styling (Default: PRIMARY).
 * @param size The [ButtonSize] determining padding (Default: MEDIUM).
 * @param shapeRadius Corner radius of the button (Default: 8dp).
 * @param enabled Whether the button is clickable and active.
 * @param onClick Lambda called when the button is clicked.
 */
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
    val showIcons = type != ButtonType.TERTIARY

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
            if (showIcons) Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, null)
            Text(text = text)
            if (showIcons) Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, null)
        }
    }
}

/**
 * Highly Customizable Button.
 * Allows passing a custom [content] lambda for complex internal layouts.
 *
 * @param modifier The modifier to be applied to the button.
 * @param type The [ButtonType] styling.
 * @param size The [ButtonSize] determining padding.
 * @param shapeRadius Corner radius of the button.
 * @param enabled Whether the button is clickable and active.
 * @param contentPadding Padding values for the content.
 * @param onClick Lambda called when the button is clicked.
 * @param content The composable content to be displayed inside the button row.
 */
@Composable
fun Button(
    modifier: Modifier = Modifier,
    type: ButtonType = ButtonType.PRIMARY,
    size: ButtonSize = ButtonSize.MEDIUM,
    shapeRadius: Dp = 8.dp,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    onClick: () -> Unit = {},
    content: @Composable (RowScope.() -> Unit),
) {
    Button(
        modifier = modifier,
        contentPadding = contentPadding,
        onClick = onClick,
        enabled = enabled,
        type = type,
        shapeRadius = shapeRadius,
        content = content,
        size = size,
    )
}


@Preview(name = "Button Preview", group = "Button Types")
// Note: Previews themselves don't pass 'type' logic;
// you usually use this for Theme (Dark/Light) or Screen Sizes.
annotation class ButtonStatePreviews

@ButtonStatePreviews
@Composable
fun ButtonCollectionPreview() {
    FixGoTheme {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    type = ButtonType.PRIMARY,
                    size = ButtonSize.LARGE,
                    text = "Button",
                )
                Button(
                    type = ButtonType.PRIMARY,
                    size = ButtonSize.LARGE,
                    text = "Button",
                    enabled = false
                )

                Button(type = ButtonType.PRIMARY, size = ButtonSize.MEDIUM, text = "Button")

                Button(
                    type = ButtonType.PRIMARY,
                    size = ButtonSize.MEDIUM,
                    text = "Button",
                    enabled = false
                )

            }
            Spacer(modifier = Modifier.height(16.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(type = ButtonType.SECONDARY, size = ButtonSize.LARGE, text = "Button")
                Button(
                    type = ButtonType.SECONDARY,
                    size = ButtonSize.LARGE,
                    text = "Button",
                    enabled = false
                )

                Button(type = ButtonType.SECONDARY, size = ButtonSize.MEDIUM, text = "Button")

                Button(
                    type = ButtonType.SECONDARY,
                    size = ButtonSize.MEDIUM,
                    text = "Button",
                    enabled = false
                )
            }
        }
    }
}

@Preview(name = "Button Preview", group = "Button Types")

@ButtonStatePreviews
@Composable
fun TertiaryPreview() {
    FixGoTheme {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    type = ButtonType.TERTIARY,
                    size = ButtonSize.LARGE,
                    text = "Button",
                )
                Button(
                    type = ButtonType.TERTIARY,
                    size = ButtonSize.LARGE,
                    text = "Button",
                    enabled = false
                )

                Button(type = ButtonType.TERTIARY, size = ButtonSize.MEDIUM, text = "Button")

                Button(
                    type = ButtonType.TERTIARY,
                    size = ButtonSize.MEDIUM,
                    text = "Button",
                    enabled = false
                )

            }
        }
    }
}




