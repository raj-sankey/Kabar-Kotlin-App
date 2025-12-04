package com.example.kabar.presentation.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val LightColors = lightColorScheme(
    primary = BluePrimary,
    secondary = GreyIcon,
    background = BackgroundWhite,
    onBackground = Color.Black
)

val DarkColors = darkColorScheme(
    primary = BluePrimary,
    secondary = Color(0xFFB0B0B0), // Light grey for icons
    background = Color(0xFF121212),
    onBackground = Color.White
)

@Composable
fun KabarAppTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}

