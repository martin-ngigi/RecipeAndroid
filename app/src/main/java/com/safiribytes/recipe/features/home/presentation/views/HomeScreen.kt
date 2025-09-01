package com.safiribytes.recipe.features.home.presentation.views

import AutoSlidingCarousel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.safiribytes.recipe.core.components.CustomSearchBar
import com.safiribytes.recipe.features.home.presentation.views.homepage.TrendingRecipesComponent
import com.safiribytes.recipe.ui.theme.RecipeAndroidTheme
import com.safiribytes.recipe.ui.theme.Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    HomeScreenContent(
        onTapBack = {

        },
        actions = {

        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent(
    onTapBack: () -> Unit,
    actions: @Composable () -> Unit
){
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors().copy(
                    containerColor = MaterialTheme.colorScheme.background
                ),
                title = {
                    Text(
                        text = "Discover Best\nRecipes",
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = MaterialTheme.colorScheme.onBackground,
                            fontSize = 22.sp
                        ),

                        )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            onTapBack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.onBackground,
                        )
                    }
                },
                actions = {
                    actions()
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(  10.dp)
        ) {
            Box(){
                Column(
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    CustomSearchBar(
                        query = "",
                        onQueryChange = { newValue ->
                        },
                        onSearch = {
                        },
                        //results = ,
                        onResultClick = {

                        }
                    )

                    AutoSlidingCarousel(
                        isLoading = false,
                        images = listOf("img1", "img2")
                    )

                    TrendingRecipesComponent(
                        recipes = listOf("1", "2", "3", "4", "5", "6"),
                        rows = 2,
                        onTapSeeAll = {

                        }
                    )

                }
            }
        }
    }
}

@Composable
@Preview
fun HomeScreenPreviewLight(){
    RecipeAndroidTheme(theme = Theme.Dark) {
        HomeScreenContent(
            onTapBack = {

            },
            actions = {

            }
        )
    }
}
