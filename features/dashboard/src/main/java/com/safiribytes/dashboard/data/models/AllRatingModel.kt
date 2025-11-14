package com.safiribytes.dashboard.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AllRatingModel(
    @SerialName("rate_id")
    val rateID: String,
    @SerialName("ratee_id")
    val rateeID: String,
    @SerialName("rater_id")
    val raterID: String,
    val rating: Double,
    val comment: String,
    val rater: UserModel
)
