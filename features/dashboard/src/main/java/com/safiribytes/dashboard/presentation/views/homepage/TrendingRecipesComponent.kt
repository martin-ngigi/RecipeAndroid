package com.safiribytes.dashboard.presentation.views.homepage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.safiribytes.coreui.theme.Theme
import com.safiribytes.coreui.theme.chefapp.ChefAppTheme
import com.safiribytes.coreui.theme.userapp.UserAppTheme
import com.safiribytes.dashboard.data.models.RecipeModel
import com.safiribytes.dashboard.presentation.views.RecipeItemView
import kotlin.collections.chunked

@Composable
fun TrendingRecipesComponent(
    recipes: List<RecipeModel> = emptyList(),
    rows: Int,
    onTapSeeAll: () -> Unit,
    onTapRecipeItem: (RecipeModel) -> Unit,
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
                        .padding(vertical = 8.dp, horizontal = 5.dp)
                ) {
                    chunck.forEach{ trendingItem ->
                        RecipeItemView(
                            onTap = {
                                onTapRecipeItem(trendingItem)
                            }
                        )

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
    UserAppTheme(theme = Theme.Light){
        TrendingRecipesComponent(
            recipes = emptyList(),
            rows = 2,
            onTapSeeAll = {

            },
            onTapRecipeItem = { item ->

            }
        )
    }
}

@Preview
@Composable
fun TrendingRecipesComponentPreviewDark(){
    ChefAppTheme(theme = Theme.Dark){
        TrendingRecipesComponent(
            recipes = emptyList(),
            rows = 2,
            onTapSeeAll = {

            },
            onTapRecipeItem = { item ->

            }
        )
    }
}