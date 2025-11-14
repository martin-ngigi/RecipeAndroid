package com.safiribytes.dashboard.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserModel(
    @SerialName("user_id")
    val userID: String,
    val name: String,
    val email: String,
    @SerialName("open_id")
    val openID: String,
    @SerialName("auth_type")
    val authType: String,
    val avatar: String,
    val role: String,
    val gender: String? = null,
    @SerialName("date_of_birth")
    val dateOfBirth: String? = null,
    val phone: String? = null,
    @SerialName("phone_complete")
    val phoneComplete: String? = null,
    @SerialName("country_code")
    val countryCode: String? = null,
    val token: String? = null,
    @SerialName("access_token")
    val accessToken: String? = null,
    @SerialName("created_at")
    val createdAt: String? = null,
    @SerialName("updated_at")
    val updatedAt: String? = null,
    @SerialName("recipes_list")
    val recipesList: List<RecipeModel>? = null,
    @SerialName("all_rates")
    val allRates: List<AllRatingModel>? = null,
    val rate: TotalRateModel? = null
) {
    val initials: String
        get() {
            val components = name.split(" ")
            val firstInitial = components.firstOrNull()?.take(1) ?: ""
            val secondInitial = if (components.size > 1) components[1].take(1) else ""
            return (firstInitial + secondInitial).uppercase()
        }
}
