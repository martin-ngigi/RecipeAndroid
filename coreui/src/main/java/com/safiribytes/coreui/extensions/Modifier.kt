package com.safiribytes.coreui.extensions

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.safiribytes.coreui.theme.DarkColors
import com.safiribytes.coreui.theme.LightColors
import com.safiribytes.coreui.theme.Theme


@Composable
fun Modifier.customCardStyle(padding: Dp = 12.dp): Modifier {
    val isDarkTheme = isSystemInDarkTheme()

    val colorsList = if (isDarkTheme)
        listOf(
        MaterialTheme.colorScheme.surface.copy(alpha = 0.5f),
        MaterialTheme.colorScheme.surface
    ) else
        listOf(
            MaterialTheme.colorScheme.surface,
            MaterialTheme.colorScheme.surface.copy(alpha = 0.5f)
        )
    return this
        .fillMaxWidth()
        .background(
            brush = Brush.linearGradient(
                colors =   listOf(
                    MaterialTheme.colorScheme.surface,
                    MaterialTheme.colorScheme.surface.copy(alpha = 0.7f)
                ),
                start = Offset(0f, 0f),
                end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
            ),
            shape = RoundedCornerShape(8.dp)
        )
        .padding(padding)
}