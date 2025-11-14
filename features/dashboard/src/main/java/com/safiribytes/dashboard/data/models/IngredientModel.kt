package com.safiribytes.dashboard.data.models
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IngredientModel(
    @SerialName("ingredient_id")
    val ingredientID: String,
    val name: String,
    val image: String,
    val quantity: String,
    @SerialName("recipe_id")
    val recipeID: String,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("updated_at")
    val updatedAt: String
)
