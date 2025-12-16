package com.safiribytes.coreui.navigation

sealed class Route (val  route: String){
    object LandingScreen: Route(route = "landingScreen")
    object DashboardScreen: Route(route = "dashboardScreen")
    object HomeScreen: Route(route = "homeScreen")
    object LoginScreen: Route(route = "loginScreen")
    object RecipeDetailsScreen: Route(route = "recipeDetailsScreen")
}