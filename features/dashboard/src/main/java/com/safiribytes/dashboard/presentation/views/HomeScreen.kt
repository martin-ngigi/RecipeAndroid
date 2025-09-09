package com.safiribytes.dashboard.presentation.views

import AutoSlidingCarousel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.safiribytes.coreui.components.CustomSearchBar
import com.safiribytes.coreui.theme.Theme
import com.safiribytes.coreui.theme.chefapp.ChefAppTheme
import com.safiribytes.coreui.theme.userapp.UserAppTheme
import com.safiribytes.dashboard.presentation.views.homepage.PopularChefsComponent
import com.safiribytes.dashboard.presentation.views.homepage.TrendingRecipesComponent

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
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ){
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                item {
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
                }

                item {
                    AutoSlidingCarousel(
                        isLoading = false,
                        images = listOf("img1", "img2")
                    )
                }

                item {
                    TrendingRecipesComponent(
                        recipes = listOf("1", "2", "3", "4", "5", "6"),
                        rows = 2,
                        onTapSeeAll = {

                        }
                    )
                }

                item {
                    PopularChefsComponent(
                        onTapSeeAll = {},
                        chefs = listOf("1", "2", "3")
                    )
                }

            }
        }
    }
}

@Composable
@Preview
fun HomeScreenPreviewLight(){
    UserAppTheme(theme = Theme.Light) {
        HomeScreenContent(
            onTapBack = {

            },
            actions = {

            }
        )
    }
}

@Composable
@Preview
fun HomeScreenPreviewDark(){
    ChefAppTheme(theme = Theme.Dark) {
        HomeScreenContent(
            onTapBack = {

            },
            actions = {

            }
        )
    }
}
