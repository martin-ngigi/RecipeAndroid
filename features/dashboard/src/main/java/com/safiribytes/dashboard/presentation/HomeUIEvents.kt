package com.safiribytes.dashboard.presentation

import com.safiribytes.dashboard.data.models.RecipeModel
import com.safiribytes.dashboard.data.models.UserModel

sealed interface HomeUIEvents {
    data object OnNavigateUp: HomeUIEvents
    data class OnNavigateToRecipeDetails(val recipe: RecipeModel): HomeUIEvents
    data object OnNavigateToSeeAllTrendingRecipes: HomeUIEvents
    data object OnNavigateToSeeAllChefs: HomeUIEvents
    data class OnNavigateToChefDetails(val chef: UserModel): HomeUIEvents
}