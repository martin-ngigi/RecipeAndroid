package com.safiribytes.coreui.theme.chefapp

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.safiribytes.coreui.theme.DarkColors
import com.safiribytes.coreui.theme.LightColors
import com.safiribytes.coreui.theme.Theme
import com.safiribytes.coreui.theme.Typography

@Composable
fun ChefAppTheme(
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