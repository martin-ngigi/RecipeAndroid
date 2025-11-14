package com.safiribytes.core.utils

sealed class UiEvents {
    data class SnackBarEvent(val message: String) : UiEvents()
    data class NavigationEvent(val route: String) : UiEvents()
}