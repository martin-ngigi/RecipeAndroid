package com.safiribytes.recipe.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColors = darkColorScheme(
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

private val LightColors = lightColorScheme(
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

@Composable
fun RecipeAndroidTheme(
    theme: Theme = Theme.FollowSystem,
    content: @Composable () -> Unit
) {
    val autoColors = when(theme){
        Theme.Light -> LightColors
        Theme.Dark -> DarkColors
        Theme.FollowSystem -> isSystemInDarkTheme().let {
            if (it) DarkColors else LightColors
        }
    }

    MaterialTheme(
        colorScheme = autoColors,
        typography = Typography,
        content = content,
    )
}

enum class Theme {
    Light,
    Dark,
    FollowSystem
}