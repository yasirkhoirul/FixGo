package com.example.core.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Primary300,
    onPrimary = Primary900,
    primaryContainer = Primary700,
    onPrimaryContainer = Primary50,

    secondary = Secondary400,
    onSecondary = Secondary900,
    secondaryContainer = Secondary700,
    onSecondaryContainer = Secondary50,

    tertiary = InfoMain,
    onTertiary = White,
    tertiaryContainer = InfoDark,
    onTertiaryContainer = InfoLight,

    background = Secondary900,
    onBackground = Secondary50,
    surface = Secondary900,
    onSurface = Secondary50,

    error = ErrorDark,
    onError = White,
    errorContainer = ErrorMain,
    onErrorContainer = ErrorLight
)

private val LightColorScheme = lightColorScheme(
    primary = Primary500,
    onPrimary = White,
    primaryContainer = Primary100,
    onPrimaryContainer = Primary900,

    secondary = Secondary500,
    onSecondary = White,
    secondaryContainer = Secondary100,
    onSecondaryContainer = Secondary900,

    tertiary = InfoMain,
    onTertiary = White,
    tertiaryContainer = InfoLight,
    onTertiaryContainer = InfoDark,

    background = White,
    onBackground = Secondary900,
    surface = White,
    onSurface = Secondary900,

    error = ErrorMain,
    onError = White,
    errorContainer = ErrorLight,
    onErrorContainer = ErrorDark
)

@Immutable
data class SemanticColors(
    val info: Color,
    val onInfo: Color,
    val infoContainer: Color,
    val onInfoContainer: Color,
    val warning: Color,
    val onWarning: Color,
    val warningContainer: Color,
    val onWarningContainer: Color,
    val success: Color,
    val onSuccess: Color,
    val successContainer: Color,
    val onSuccessContainer: Color,
)

private val LightSemanticColors = SemanticColors(
    info = InfoMain,
    onInfo = White,
    infoContainer = InfoLight,
    onInfoContainer = InfoDark,
    warning = WarningMain,
    onWarning = Secondary900,
    warningContainer = WarningLight,
    onWarningContainer = WarningDark,
    success = SuccessMain,
    onSuccess = White,
    successContainer = SuccessLight,
    onSuccessContainer = SuccessDark,
)

private val DarkSemanticColors = SemanticColors(
    info = InfoMain,
    onInfo = White,
    infoContainer = InfoDark,
    onInfoContainer = InfoLight,
    warning = WarningMain,
    onWarning = Secondary900,
    warningContainer = WarningDark,
    onWarningContainer = WarningLight,
    success = SuccessMain,
    onSuccess = White,
    successContainer = SuccessDark,
    onSuccessContainer = SuccessLight,
)

private val LocalSemanticColors = staticCompositionLocalOf { LightSemanticColors }

object FixGoThemeExt {
    val semanticColors: SemanticColors
        @Composable
        @ReadOnlyComposable
        get() = LocalSemanticColors.current
}

@Composable
fun FixGoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Keep custom palette as default; enable dynamic only when needed.
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val semanticColors = if (darkTheme) DarkSemanticColors else LightSemanticColors

    CompositionLocalProvider(LocalSemanticColors provides semanticColors) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}