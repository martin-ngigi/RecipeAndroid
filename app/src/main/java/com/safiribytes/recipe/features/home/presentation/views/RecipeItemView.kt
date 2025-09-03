package com.safiribytes.recipe.features.home.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.safiribytes.recipe.core.utils.CustomImageView
import com.safiribytes.recipe.ui.theme.RecipeAndroidTheme
import com.safiribytes.recipe.ui.theme.Theme

@Composable
fun RecipeItemView(
    modifier: Modifier = Modifier,
    name: String = "Name",
    rating: String = "4.0",
    imageUrl: String = ""
) {
    Box(
        modifier = modifier
            .size(width = 170.dp, height = 150.dp)
            .clip(RoundedCornerShape(10.dp))
    ) {
        // Background image
        CustomImageView(
            url = imageUrl,
            maxWidth = 200.dp,
            height = 200.dp,
            modifier = Modifier.fillMaxSize()
        )

        // Frosted glass bottom bar
        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
                .height(50.dp)
        ) {
            // Blur layer BEHIND content
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .blur(20.dp)
                    .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.4f))
            )

            // Foreground text + icons (NOT blurred)
            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp),
                modifier = Modifier.padding(horizontal = 13.dp, vertical = 6.dp)
            ) {
                Text(
                    text = name,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(14.dp)
                    )

                    Text(
                        text = rating,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colorScheme.primary
                        ),
                        modifier = Modifier.padding(start = 4.dp)
                    )

                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}


@Preview
@Composable
fun RecipeItemViewPreviewLight(){
    RecipeAndroidTheme (Theme.Light){
        RecipeItemView()
    }
}

@Preview
@Composable
fun RecipeItemViewPreviewDark(){
    RecipeAndroidTheme (Theme.Dark){
        RecipeItemView()
    }
}

