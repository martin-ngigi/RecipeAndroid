package com.safiribytes.recipe.features.home.presentation.views.homepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.safiribytes.recipe.features.home.presentation.views.RecipeItemView
import com.safiribytes.recipe.ui.theme.RecipeAndroidTheme
import com.safiribytes.recipe.ui.theme.Theme

@Composable
fun TrendingRecipesComponent(
    onTapSeeAll: () -> Unit
){

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top
    ) {
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){

            Text(
                text = "Trending Recipes",
                style = MaterialTheme.typography.bodyMedium
            )

            Row(
                modifier = Modifier
                    .clickable{
                        onTapSeeAll()
                    }
            ) {
                Text(
                    text = "See All",
                    style = MaterialTheme.typography.bodyMedium
                )

                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(14.dp)
                )
            }
        }

        RecipeAndroidTheme(theme = Theme.Light) {
            RecipesGrid(
                onTap = {},
                orientation = GridOrientation.Vertical
            )
        }


    }
}

@Preview
@Composable
fun TrendingRecipesComponentPreviewLight(){
    RecipeAndroidTheme (theme = Theme.Light){
        TrendingRecipesComponent(
            onTapSeeAll = {

            }
        )
    }
}

@Preview
@Composable
fun TrendingRecipesComponentPreviewDark(){
    RecipeAndroidTheme (theme = Theme.Dark){
        TrendingRecipesComponent(
            onTapSeeAll = {

            }
        )
    }
}