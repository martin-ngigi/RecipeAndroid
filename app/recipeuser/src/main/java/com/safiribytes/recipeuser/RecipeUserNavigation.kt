package com.safiribytes.recipeuser

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.safiribytes.coreui.navigation.Route
import com.safiribytes.coreui.scaleInEnterTransition
import com.safiribytes.coreui.scaleInPopEnterEnterTransition
import com.safiribytes.coreui.scaleOutExitTransition
import com.safiribytes.dashboard.presentation.dashboardNavigation
import com.safiribytes.dashboard.presentation.views.HomeScreen
import com.safiribytes.landing.presentation.views.LandingScreen

@Composable
fun RecipeUserNavigation(
    startDestination: String,
    navController: NavHostController,
    isDrawerOpened: Boolean,
    onDrawerOpen: (Boolean) -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        enterTransition = { scaleInEnterTransition() },
        exitTransition = { scaleOutExitTransition() },
        popEnterTransition = { scaleInPopEnterEnterTransition() },
        popExitTransition = { scaleOutExitTransition() },
    ){
        authenticationNavGraph(navController = navController)
        dashboardNavigation(navController = navController)
    }

}



fun NavGraphBuilder.authenticationNavGraph(
    navController: NavController
){
    composable(
        route = Route.LandingScreen.route
    ) {
        LandingScreen(navController = navController)
    }
}