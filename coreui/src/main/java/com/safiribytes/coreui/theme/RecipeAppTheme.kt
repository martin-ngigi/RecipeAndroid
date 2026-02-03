package com.safiribytes.coreui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import com.safiribytes.core.utils.AppType
import com.safiribytes.coreui.theme.chefapp.ChefAppTheme
import com.safiribytes.coreui.theme.userapp.UserAppTheme

@Composable
fun RecipeAppTheme(
    darkMode: Boolean = isSystemInDarkTheme(),
    appType: AppType,
    content: @Composable () -> Unit
){
    when(appType){
        AppType.USER -> {
            UserAppTheme(
                content = content
            )
        }
        AppType.CHEF -> {
            ChefAppTheme(
                content = content
            )
        }
    }

}