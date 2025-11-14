package com.safiribytes.dashboard.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeData(
    @SerialName("just_for_you")
    val justForYou: List<RecipeModel>,
    @SerialName("trending_recipes")
    val trendingRecipes: List<RecipeModel>,
    @SerialName("popular_chefs")
    val popularChefs: List<UserModel>
)
