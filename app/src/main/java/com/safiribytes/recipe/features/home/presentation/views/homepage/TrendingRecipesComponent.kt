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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
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
import kotlin.collections.chunked

@Composable
fun TrendingRecipesComponent(
    onTapSeeAll: () -> Unit,
    recipes: List<String>,
    rows: Int
){

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top
    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
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

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            contentPadding = PaddingValues(horizontal =  3.dp)
        ) {
            items(recipes.chunked(rows)){ chunck ->
                Column(
                    verticalArrangement = Arrangement.spacedBy(15.dp),
                    modifier = Modifier
                        .width(150.dp)
                        .padding(vertical = 8.dp, horizontal = 5.dp)
                ) {
                    chunck.forEach{ trendingItem ->

                        RecipeItemView()

                    }
                }
            }
        }

        /*
        RecipesGrid(
            onTap = {},
            orientation = GridOrientation.Vertical
        )
        */


    }
}

@Preview
@Composable
fun TrendingRecipesComponentPreviewLight(){
    RecipeAndroidTheme (theme = Theme.Light){
        TrendingRecipesComponent(
            recipes = listOf("1", "2", "3", "4", "5", "6"),
            rows = 2,
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
            recipes = listOf("1", "2", "3", "4", "5", "6"),
            rows = 2,
            onTapSeeAll = {

            }
        )
    }
}