package com.safiribytes.dashboard.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.safiribytes.coreui.navigation.Route
import com.safiribytes.dashboard.presentation.views.DashboardScreen
import com.safiribytes.dashboard.presentation.views.HomeScreen

fun NavGraphBuilder.dashboardNavigation(
    navController: NavController
){
    composable(route = Route.DashboardScreen.route){
        DashboardScreen(navController = navController)
    }

    composable(route = Route.HomeScreen.route){
        HomeScreen(navController = navController)
    }

}