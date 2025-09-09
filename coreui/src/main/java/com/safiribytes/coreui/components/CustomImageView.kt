package com.safiribytes.coreui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.safiribytes.coreui.R

@Composable
fun CustomImageView(
    url: String,
    maxWidth: Dp = Dp.Unspecified,
    height: Dp = 256.dp,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = url,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .then(if (maxWidth != Dp.Unspecified) Modifier.widthIn(max = maxWidth) else Modifier.fillMaxWidth())
            .height(height),
        placeholder = painterResource(id = R.drawable.image_placeholder),
        error = painterResource(id = R.drawable.error_image)
    )
}
