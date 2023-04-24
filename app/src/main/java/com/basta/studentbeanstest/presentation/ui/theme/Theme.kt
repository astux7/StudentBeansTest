package com.basta.studentbeanstest.presentation.ui.theme

import android.app.Activity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat

private val LightColorScheme = lightColors(
    primary = ColorBlue,
    secondary = ColorDarkBlue,
    onSecondary = ColorWhite,
    background = ColorBlue,
    onBackground = ColorWhite,
    onSurface = ColorWhite,
    surface = ColorDarkBlue,
    error = ColorError
)

@Composable
fun StudentBeansTestTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = true
        }
    }

    MaterialTheme(
        colors = colorScheme,
        typography = Typography,
        content = content
    )
}