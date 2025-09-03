package com.safiribytes.recipe.core.extensions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Modifier.customCardStyle(padding: Dp = 12.dp): Modifier = this
    .fillMaxWidth()
    .background(MaterialTheme.colorScheme.surfaceContainer, shape = RoundedCornerShape(8.dp))
    //.background(if (isSystemInDarkTheme()) CardContainerDark else CardContainerLight, shape = RoundedCornerShape(8.dp))
//    .background(CardContainerDark)
    .padding(padding)