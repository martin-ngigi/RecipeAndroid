package com.safiribytes.dashboard.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeModel(
    @SerialName("recipe_id")
    val recipeId: String,
    @SerialName("open_id")
    val openId: String,
    val name: String,
    val description: String,
    @SerialName("ingredients_list")
    val ingredients: List<IngredientModel>,
    val image: String,
    val instructions: String,
    val chef: UserModel? = null,
    val isInFavorite: Boolean? = null
) {
    val instructionsList: List<String>
        get() {
            val pattern = "\\d+\\.\\s*".toRegex()
            return instructions.split(pattern).map { it.trim() }.filter { it.isNotEmpty() }
        }

}
