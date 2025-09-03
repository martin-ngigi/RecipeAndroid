package com.safiribytes.recipe.features.home.presentation.views.homepage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.safiribytes.recipe.core.utils.CustomImageView
import com.safiribytes.recipe.features.home.presentation.views.RecipeItemView
import com.safiribytes.recipe.ui.theme.RecipeAndroidTheme
import com.safiribytes.recipe.ui.theme.Theme
import kotlin.collections.chunked

@Composable
fun PopularChefsComponent(
    chefs: List<String>,
    onTapSeeAll: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(space = 5.dp, alignment = Alignment.Top )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Trending Recipes",
                style = MaterialTheme.typography.bodyMedium
            )

            Row(
                modifier = Modifier
                    .clickable {
                        onTapSeeAll()
                    }
            ) {
                Text(
                    text = "See All",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.primary
                    )
                )

                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(14.dp)
                )
            }
        }

        Column (
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            //contentPadding = PaddingValues(vertical = 5.dp)
        ) {
            chefs.forEach { chef ->
                ChefHomeRow()
            }

        }
    }


}


@Preview
@Composable
fun PopularChefsComponentLightPreview(){
    RecipeAndroidTheme(theme = Theme.Light) {
        PopularChefsComponent(
            onTapSeeAll = {},
            chefs = listOf("1", "2", "3")
        )
    }
}

@Preview
@Composable
fun PopularChefsComponentDarkPreview(){
    RecipeAndroidTheme(theme = Theme.Dark) {
        PopularChefsComponent(
            onTapSeeAll = {},
            chefs = listOf("1", "2", "3")
        )
    }
}