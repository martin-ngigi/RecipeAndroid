package com.safiribytes.dashboard.presentation.views

import AutoSlidingCarousel
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import com.safiribytes.core.utils.UiEvents
import com.safiribytes.coreui.components.CustomSearchBar
import com.safiribytes.coreui.theme.Theme
import com.safiribytes.coreui.theme.chefapp.ChefAppTheme
import com.safiribytes.coreui.theme.userapp.UserAppTheme
import com.safiribytes.dashboard.presentation.HomeUIEvents
import com.safiribytes.dashboard.presentation.HomeUIState
import com.safiribytes.dashboard.presentation.viewmodels.HomeViewModel
import com.safiribytes.dashboard.presentation.views.homepage.PopularChefsComponent
import com.safiribytes.dashboard.presentation.views.homepage.TrendingRecipesComponent
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import androidx.compose.ui.platform.LocalContext
import com.safiribytes.coreui.navigation.Route

@SuppressLint("RememberReturnType")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel()
){

    val uiState = homeViewModel.uiState.collectAsState().value
    val coroutineScope = rememberCoroutineScope()
    val snackBarHostState = remember {
        SnackbarHostState()
    }
    val context = LocalContext.current
    val TAG = "HomeScreen"

    LaunchedEffect(key1 = Unit) {
        homeViewModel.uiEvents.collectLatest { event ->
            when(event){
                is UiEvents.NavigationEvent -> {
                    navController.navigate(event.route)
                }
                is UiEvents.SnackBarEvent -> {
                    coroutineScope.launch {
                        snackBarHostState.showSnackbar(
                            message = event.message
                        )
                    }
                }
            }
        }
    }

    HomeScreenContent(
        uiState = uiState,
        onEvents = { event ->
            when(event){
                is HomeUIEvents.OnNavigateUp ->{
                    navController.navigateUp()
                }
                is HomeUIEvents.OnNavigateToRecipeDetails -> {
                    navController.navigate(Route.RecipeDetailsScreen)
                }
                else -> {
                    Log.d(TAG, "HomeScreen: ")
                }
            }
            homeViewModel.onEvent(event = event)
        },
        actions = {

        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent(
    uiState: HomeUIState,
    onEvents: (HomeUIEvents) -> Unit,
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
                            onEvents(HomeUIEvents.OnNavigateUp)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
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
                        onResultClick = {

                        }
                    )
                }

                item {
                    AutoSlidingCarousel(
                        isLoading = false,
                        images = uiState.homeResponseModel?.data?.justForYou?.map { it.image } as List<String>
                    )
                }

                item {
                    TrendingRecipesComponent(
                        recipes = uiState.homeResponseModel?.data?.trendingRecipes ?: emptyList(),
                        rows = 2,
                        onTapSeeAll = {
                            onEvents(HomeUIEvents.OnNavigateToSeeAllTrendingRecipes)
                        },
                        onTapRecipeItem = { recipeItem ->
                            onEvents(HomeUIEvents.OnNavigateToRecipeDetails(recipe = recipeItem))
                        }
                    )
                }

                item {
                    PopularChefsComponent(
                        chefs = uiState.homeResponseModel?.data?.popularChefs ?: emptyList(),
                        onTapSeeAll = {
                            onEvents(HomeUIEvents.OnNavigateToSeeAllChefs)
                        },
                        onTapChef = { chef ->
                            onEvents(HomeUIEvents.OnNavigateToChefDetails(chef = chef))
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
    UserAppTheme(theme = Theme.Light) {
        HomeScreenContent(
            uiState = HomeUIState(
                isLoading = false,
                homeResponseModel = null,
                message = null
            ),
            onEvents = { event ->

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
            uiState = HomeUIState(
                isLoading = false,
                homeResponseModel = null,
                message = null
            ),
            onEvents = { event ->

            },
            actions = {

            }
        )
    }
}
