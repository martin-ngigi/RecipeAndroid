package com.safiribytes.coreui.navigation

sealed class Route (val  route: String){
    object HomeScreen: Route(route = "homeScreen")
    object LoginScreen: Route(route = "loginScreen")
}