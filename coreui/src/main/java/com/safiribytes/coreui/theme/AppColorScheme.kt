package com.safiribytes.coreui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val DarkColors = darkColorScheme(
    primary = PrimaryDarkColor,
    onPrimary = PrimaryTextColor,
    secondary = SecondaryLightColor,
    onSecondary = SecondaryTextColor,
    tertiary = PrimaryLightColor,
    onTertiary = PrimaryTextColor,
    background = BackgroundDarkColor,
    onBackground = Color.White,
    surface = SurfaceDark,
    onSurface = Color.White,
    surfaceVariant = SurfaceDark,
    onSurfaceVariant = Color.White,
    secondaryContainer = PrimaryDarkColor,
    onSecondaryContainer = Color.White,
    error = ErrorColor,
    onError = OnErrorColor,
    surfaceContainer = CardContainerDark, // For cards
)

val LightColors = lightColorScheme(
    primary = PrimaryLightColor,
    onPrimary = PrimaryTextColor,
    secondary = SecondaryColor,
    onSecondary = SecondaryTextColor,
    tertiary = PrimaryLightColor,
    onTertiary = PrimaryTextColor,
    background = BackgroundLightColor,
    onBackground = Color.Black,
    surface = SurfaceLight,
    onSurface = Color.Black,
    surfaceVariant = SurfaceLight,
    onSurfaceVariant = Color.Black,
    secondaryContainer = PrimaryLightColor,
    onSecondaryContainer = Color.White,
    error = ErrorColor,
    onError = OnErrorColor,
    surfaceContainer = CardContainerLight,
)